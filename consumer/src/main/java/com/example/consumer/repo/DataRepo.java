package com.example.consumer.repo;

import com.example.consumer.models.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo extends CrudRepository<Data, Integer> {
}
