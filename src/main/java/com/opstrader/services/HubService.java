package com.opstrader.services;

import com.opstrader.entities.Future;
import com.opstrader.entities.Hub;
import com.opstrader.models.GlobalSpec;
import com.opstrader.repos.FutureRepository;
import com.opstrader.repos.HubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HubService {

    public HubRepository repo;

    @Autowired
    public HubService(HubRepository repo) {
        this.repo = repo;
    }

    // READ
    public List<Hub> findAll() {
        return this.repo.findAll();
    }

    // READ
    public Optional<Hub> find(long id) {
        return this.repo.findById(id);
    }

}
