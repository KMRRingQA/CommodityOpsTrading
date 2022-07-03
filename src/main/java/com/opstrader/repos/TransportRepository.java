package com.opstrader.repos;

import com.opstrader.entities.Hub;
import com.opstrader.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
}

