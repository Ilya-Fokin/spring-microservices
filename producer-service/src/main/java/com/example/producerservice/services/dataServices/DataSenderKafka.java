package com.example.producerservice.services.dataServices;

import com.example.producerservice.models.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.function.Consumer;

@Slf4j
public class DataSenderKafka implements DataSender {
    private final String key = "data";

    private final KafkaTemplate<String, Data> kafkaTemplate;

    private final NewTopic topic;

    private final Consumer<Data> sendAsk;

    public DataSenderKafka(
            KafkaTemplate<String, Data> kafkaTemplate,
            NewTopic topic,
            Consumer<Data> sendAsk
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
        this.sendAsk = sendAsk;
    }

    @Override
    public void send(Data data) {
        log.info(data.toString());
        try {
            kafkaTemplate.send(topic.name(), data)
                    .whenComplete(
                            (result, ex) -> {
                                if (ex == null) {
                                    log.info("Успешно отправились данные {}", result.toString());
                                } else {
                                    log.error("Возникла ошибка: {}", ex.toString());
                                }
                            }
                    );
        } catch (Exception ex) {
            log.error(ex.toString());
        }

    }
}
