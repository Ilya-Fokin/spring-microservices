package com.example.producerservice.services.dataServices;

import com.example.producerservice.models.Data;

@FunctionalInterface
public interface DataCreator {
    Data create(int maxLength);
}
