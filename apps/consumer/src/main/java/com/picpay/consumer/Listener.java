package com.picpay.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "mytopic")
    public void listen(Message message) {
        log.info("Received: " + message);
    }
}
