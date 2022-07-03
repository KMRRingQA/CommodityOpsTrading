package com.opstrader.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opstrader.dto.FutureDto;
import com.opstrader.dto.TradeDto;
import com.opstrader.entities.Future;
import com.opstrader.entities.Transport;
import com.opstrader.models.AvailableFuture;
import com.opstrader.models.Combo;
import com.opstrader.models.GlobalSpec;
import com.opstrader.models.Trade;
import com.opstrader.repos.FutureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CalcService {

    public FutureRepository repo;

    private List<Future> futures;
    private List<Trade> viableTrades;
    private List<TradeDto> viableTradesDto;

    @Autowired
    public CalcService(FutureRepository repo) {
        this.repo = repo;
    }

    // READ
    @Transactional(propagation= Propagation.REQUIRED)
    public List<Future> findAll() {
        return this.repo.findAll();
    }

    //main calc
    @Transactional(propagation= Propagation.REQUIRED)
    public List<TradeDto> refresh(){

        //get all futures from repo
        this.futures = this.repo.findAll();

        viableTradesDto = futures.stream()
                .filter(sellFuture->sellFuture.getBuy()==false)  //all sell futures
                .flatMap(sellFuture->futures.stream()  //combine with buy futures
                        .filter(buyFuture1->buyFuture1.getBuy()==true) //ony buy futures
                        .filter(buyFuture1->buyFuture1.getSpec()<sellFuture.getSpec())//must be lower spec (to combine)
                        .filter(buyFuture1->{
                            if(buyFuture1.getHub()==sellFuture.getHub() || buyFuture1.getHub().getTransportsTo().stream().filter(t->t.getHubTo()==sellFuture.getHub()).findAny().get().getDuration()<
                            buyFuture1.getDate().until(sellFuture.getDate()).get(ChronoUnit.DAYS)){
                                return true; //must be able to reach sell hub on time
                            } return false;
                        })
                        .flatMap(buyFuture1->futures.stream() //combine with buy future 2
                                .filter(buyFuture2->buyFuture2.getBuy()==true) //only buy futures
                                .filter(buyFuture2->buyFuture2.getSpec()>sellFuture.getSpec()) //higher spec than sell (to combine)
                                .filter(buyFuture2->{
                                    if(buyFuture2.getHub()==sellFuture.getHub() || buyFuture2.getHub().getTransportsTo().stream().filter(t->t.getHubTo()==sellFuture.getHub()).findAny().get().getDuration()<
                                            buyFuture2.getDate().until(sellFuture.getDate()).get(ChronoUnit.DAYS)){
                                        return true; //must reach port on time
                                    } return false;
                                })
                                .filter(buyFuture2->{
                                    Double specFrac = (Double.valueOf(sellFuture.getSpec())-Double.valueOf(buyFuture2.getSpec()))/(Double.valueOf(buyFuture1.getSpec()-Double.valueOf(buyFuture2.getSpec())));
                                    if(Double.parseDouble(String.valueOf(sellFuture.getPrice()))>specFrac*Double.parseDouble(String.valueOf(buyFuture1.getPrice()))+(1-specFrac)*Double.parseDouble(String.valueOf(buyFuture2.getPrice()))){
                                        return true; //must be profitable - disregarding storage and transport
                                    }
                                    return false;
                                })
                                .filter(buyFuture2->{
                                    Double specFrac = (Double.valueOf(sellFuture.getSpec())-Double.valueOf(buyFuture2.getSpec()))/(Double.valueOf(buyFuture1.getSpec()-Double.valueOf(buyFuture2.getSpec())));
                                    Double transportQuant;
                                    Double transportCost;
                                    Double storageCost;
                                    Double buyCost;

                                    if(buyFuture2.getHub()==sellFuture.getHub() || buyFuture1.getHub()==sellFuture.getHub()){
                                        return false; //need to implement 0 transport calcs
                                    }
                                    Transport transport1 = buyFuture1.getHub().getTransportsTo().stream().filter(t->t.getHubTo()== sellFuture.getHub()).findAny().get(); //identify transport routes
                                    Transport transport2 = buyFuture2.getHub().getTransportsTo().stream().filter(t->t.getHubTo()== sellFuture.getHub()).findAny().get();

                                    transportQuant = Math.min(Math.min(sellFuture.getQuantity(), transport1.getCapacity()/specFrac),transport2.getCapacity()/(1-specFrac)); //how much can we transport
                                    transportCost = transport1.getPrice().doubleValue() + transport2.getPrice().doubleValue(); //identify transport costs

                                    buyCost = transportQuant*specFrac*(buyFuture1.getPrice().doubleValue())/buyFuture1.getQuantity() //identify total buy cost
                                            + transportQuant*specFrac*(buyFuture2.getPrice().doubleValue())/buyFuture2.getQuantity();

                                    storageCost = Math.min(buyFuture1.getHub().getStorages().stream().min(Comparator.comparingDouble(price -> price.getPrice().doubleValue())).get().getPrice().doubleValue(),
                                                    sellFuture.getHub().getStorages().stream().min(Comparator.comparingDouble(price -> price.getPrice().doubleValue())).get().getPrice().doubleValue())
                                                    *(buyFuture1.getDate().until(sellFuture.getDate()).get(ChronoUnit.DAYS) - transport1.getDuration()) * transportQuant * specFrac +
                                            Math.min(buyFuture2.getHub().getStorages().stream().min(Comparator.comparingDouble(price -> price.getPrice().doubleValue())).get().getPrice().doubleValue(),
                                                    sellFuture.getHub().getStorages().stream().min(Comparator.comparingDouble(price -> price.getPrice().doubleValue())).get().getPrice().doubleValue())
                                                    *(buyFuture2.getDate().until(sellFuture.getDate()).get(ChronoUnit.DAYS) - transport1.getDuration()) * transportQuant * (1-specFrac); //identify most efficient storage costs

                                    if(sellFuture.getQuantity()* sellFuture.getPrice().doubleValue()/ sellFuture.getQuantity()<(transportCost+storageCost+buyCost)){
                                        return false; //check profitability against all 3
                                    }
                                    return true;
                                })
                                .map(buyFuture2-> new TradeDto(
                                        new FutureDto(sellFuture.getDate(),sellFuture.getSpec(),sellFuture.getQuantity(),sellFuture.getPrice(),sellFuture.getHub().getName()),
                                        new FutureDto(buyFuture1.getDate(),buyFuture1.getSpec(),buyFuture1.getQuantity(),buyFuture1.getPrice(),buyFuture1.getHub().getName()),
                                        new FutureDto(buyFuture2.getDate(),buyFuture2.getSpec(),buyFuture2.getQuantity(),buyFuture2.getPrice(),buyFuture2.getHub().getName())
                                )))).collect(Collectors.toList());

        return viableTradesDto;
    }

}

