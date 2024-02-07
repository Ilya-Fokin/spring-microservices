package com.example.consumer.dto;

import com.netflix.discovery.provider.Serializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {
    private String word;

    @Override
    public String toString() {
        return "DataDto{" +
                "word='" + word + '\'' +
                '}';
    }
}