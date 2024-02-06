package com.example.consumer.configs;

import com.example.consumer.dto.DataDto;
import com.example.consumer.models.Data;
import com.example.consumer.services.DataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;

import static org.springframework.kafka.support.serializer.JsonDeserializer.TYPE_MAPPINGS;

@Slf4j
@Configuration
public class Config {

    private final String topic;

    public Config(@Value("${application.kafka.topic}") String topic) {
        this.topic = topic;
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topic).partitions(1).replicas(1).build();
    }

    @Bean
    public KafkaClient kafkaClient() {
        return new KafkaClient();
    }

    public static class KafkaClient {
        @Autowired
        private DataServiceImpl dataService;

        @KafkaListener(
                topics = "${application.kafka.topic}"
        )
        public void listener(@Payload DataDto data) {
            log.info("Получено сообшение: {}", data.toString());
            //dataService.save(data);
        }
    }

}
