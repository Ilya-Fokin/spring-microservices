package com.example.producerservice.services.dataServices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Runner implements CommandLineRunner {
    private final DataGenerator dataGenerator;

    public Runner(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    @Override
    public void run(String... args) throws Exception {
        dataGenerator.generate();
    }
}
