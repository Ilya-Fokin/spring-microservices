package com.example.producerservice.configs;

import com.example.producerservice.models.Data;
import com.example.producerservice.services.dataServices.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Slf4j
@Configuration
public class Config {

    private final String topic;

    public Config(@Value("${application.kafka.topic}") String topic) {
        this.topic = topic;
    }

    @Bean
    public KafkaTemplate<String, Data> kafkaTemplate(ProducerFactory<String, Data> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topic).partitions(1).replicas(1).build();
    }

    @Bean
    public DataSender dataSender(NewTopic topic, KafkaTemplate<String, Data> kafkaTemplate) {
        return new DataSenderKafka(
                kafkaTemplate,
                topic,
                data -> log.info(data.toString()
                )
        );
    }

    @Bean
    public DataGeneratorImpl dataGenerator(DataCreator dataCreator, DataSender dataSender) {
        return new DataGeneratorImpl(dataCreator, dataSender);
    }

    @Bean
    public DataCreatorImpl dataCreator() {
        return new DataCreatorImpl();
    }
}
