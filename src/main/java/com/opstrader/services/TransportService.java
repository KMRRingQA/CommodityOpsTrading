package com.opstrader.services;

import com.opstrader.entities.Hub;
import com.opstrader.entities.Transport;
import com.opstrader.repos.HubRepository;
import com.opstrader.repos.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    public TransportRepository repo;

    @Autowired
    public TransportService(TransportRepository repo) {
        this.repo = repo;
    }

    // READ
    public List<Transport> findAll() {
        return this.repo.findAll();
    }

    // READ
    public Optional<Transport> find(long id) {
        return this.repo.findById(id);
    }

}
