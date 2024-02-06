package com.example.consumer.services;

import com.example.consumer.dto.DataDto;
import com.example.consumer.mappers.DataMapper;
import com.example.consumer.models.Data;
import com.example.consumer.repo.DataRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataServiceImpl implements DataService{
    @Autowired
    private DataRepo dataRepo;

    @Override
    public void save(Data data) {
        if (!dataRepo.existsById(data.getId())) {
            dataRepo.save(data);
        }
    }

    @Override
    public void save(DataDto dataDto) {
        Data data = DataMapper.INSTANCE.dataDtoToData(dataDto);
        log.info("Объект {} сохраняется в бд", data.toString());

    }
}
