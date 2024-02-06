package com.example.producerservice.services.dataServices;

import com.example.producerservice.models.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;

@Slf4j
public class DataCreatorImpl implements DataCreator {
    @Override
    public Data create(int maxLength) {
        int wordLength = (int) (Math.random() * (maxLength - 1 + 1) + 1);
        DataCreator creator = x -> new Data(RandomStringUtils.randomAlphanumeric(x));
        log.info("Создано новое сообщение");
        return creator.create(wordLength);
    }
}
