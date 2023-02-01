package com.picpay.consumer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Service2 {

    private final Service3 service3;

    public void receive(Message message) {
        service3.receive(message);
    }
}
