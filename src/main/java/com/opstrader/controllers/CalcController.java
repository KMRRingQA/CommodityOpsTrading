package com.opstrader.controllers;

import com.opstrader.dto.TradeDto;
import com.opstrader.entities.Future;
import com.opstrader.entities.TradePlan;
import com.opstrader.models.GlobalSpec;
import com.opstrader.models.Trade;
import com.opstrader.services.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/calc")
public class CalcController {

    private CalcService calcService;

    @Autowired
    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    // refresh
    @GetMapping("/       ")
    public ResponseEntity<List<Future>> findAll() {
        return new ResponseEntity<List<Future>>(this.calcService.findAll(),HttpStatus.OK);
    }
    // findAll
    @GetMapping("/refresh")
    public ResponseEntity<List<TradeDto>> refresh() {
        return new ResponseEntity<List<TradeDto>>(this.calcService.refresh(),HttpStatus.OK);
    }


}
