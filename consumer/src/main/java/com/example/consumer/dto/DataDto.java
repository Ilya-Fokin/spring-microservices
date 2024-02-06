package com.example.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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