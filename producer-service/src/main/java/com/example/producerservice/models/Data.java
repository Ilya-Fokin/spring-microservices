package com.example.producerservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private String word;

    @Override
    public String toString() {
        return "Data{" +
                "word='" + word + '\'' +
                '}';
    }
}
