package com.picpay.consumer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Service1 {

    private final Service2 service2;

    public void receive(Message message) {
        service2.receive(message);
    }
}
