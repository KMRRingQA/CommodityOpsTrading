package com.opstrader;

import com.opstrader.entities.Future;
import com.opstrader.entities.Hub;
import com.opstrader.entities.Transport;
import com.opstrader.models.GlobalSpec;
import com.opstrader.services.CalcService;
import com.opstrader.services.HubService;
import com.opstrader.services.TransportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OpstraderApplicationTests {

	private CalcService calcService;
	private HubService hubService;
	private TransportService transportService;

	@Autowired
	public OpstraderApplicationTests(CalcService calcService, HubService hubService,TransportService transportService) {
		this.hubService = hubService;
		this.calcService = calcService;
		this.transportService = transportService;
	}

	@Test
	@Transactional
	public void findAllFuturesTest(){
		List<Future> futures = this.calcService.findAll();
		System.out.println(futures);
		assertNotEquals(0,futures.size());
		assertNotNull(futures);
	}

	@Test
	public void refresh(){
		this.calcService.refresh();
	}

	@Test
	@Transactional
	public void findAllHubsTest(){
		List<Hub> hubs = this.hubService.findAll();
		assertNotEquals(0,hubs.size());
		assertNotNull(hubs);
	}

	@Test
	@Transactional
	public void findHubTest(){
		Hub hub = this.hubService.find(1).get();
		System.out.println(hub.getTransportsFrom().size());
		System.out.println(hub.getTransportsTo().size());
		assertNotNull(hub);
	}

	@Test
	@Transactional
	public void findAllTransportTest(){
		List<Transport> transports = transportService.findAll();
		assertNotNull(transports);
	}

	@Test
	@Transactional
	public void findTransportTest(){
		Transport transport = this.transportService.find(1).get();
		System.out.println(transport);
		assertNotNull(transport);
	}


}
