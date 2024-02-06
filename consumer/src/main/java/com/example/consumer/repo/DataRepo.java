package com.example.consumer.repo;

import com.example.consumer.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataRepo extends CrudRepository<Data, Integer> {
}
