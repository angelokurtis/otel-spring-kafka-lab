package com.picpay.consumer;

import com.newrelic.api.agent.Trace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Service3 {
//    @Trace(metricName = "com.picpay.consumer.Service3.receive")
    public void receive(Message message) {
        log.info("Service3 received: " + message);
    }
}
