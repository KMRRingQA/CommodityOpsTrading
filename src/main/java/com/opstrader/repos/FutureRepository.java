package com.opstrader.repos;

import com.opstrader.entities.Future;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FutureRepository extends CrudRepository<Future, Long> {
    @Override
    @Query(value = "select * from Future", nativeQuery = true)
    List<Future> findAll();

    @Query(value = "select * from Future where id = ?1 ", nativeQuery = true)
    Optional<Future> findById(long id);
}

