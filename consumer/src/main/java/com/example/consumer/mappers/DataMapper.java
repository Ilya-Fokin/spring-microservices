package com.example.consumer.mappers;

import com.example.consumer.dto.DataDto;
import com.example.consumer.models.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DataMapper {
    DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

    Data dataDtoToData(DataDto dataDto);

    DataDto dataToDataDto(Data data);
}
