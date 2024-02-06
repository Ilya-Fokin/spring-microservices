package com.example.producerservice.services.dataServices;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DataGeneratorImpl implements DataGenerator{

    private final DataCreator dataCreator;

    private final DataSender dataSender;

    public DataGeneratorImpl(DataCreator dataCreator, DataSender dataSender) {
        this.dataCreator = dataCreator;
        this.dataSender = dataSender;
    }

    @Override
    public void generate() {
        var executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> dataSender.send(dataCreator.create(100)), 0, 1, TimeUnit.SECONDS);
        log.info("Started send");
    }
}
