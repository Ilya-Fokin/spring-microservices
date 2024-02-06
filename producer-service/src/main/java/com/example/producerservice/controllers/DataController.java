package com.example.producerservice.controllers;

import com.example.producerservice.models.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

    @GetMapping("/get")
    public Data get() {
        log.info("Запрос сообщения");
        return null;
    }
}
