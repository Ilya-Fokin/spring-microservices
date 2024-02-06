package com.example.consumer.services;

import com.example.consumer.dto.DataDto;
import com.example.consumer.models.Data;

public interface DataService {
    void save(Data data);
    void save(DataDto dataDto);
}
