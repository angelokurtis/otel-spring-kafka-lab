package com.picpay.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaTemplate<Object, Object> template;

    public Controller(KafkaTemplate<Object, Object> template) {
        this.template = template;
    }

    @PostMapping(path = "/send/{foo}")
    public void sendFoo(@PathVariable String foo) {
        this.template.send("mytopic", new PushMessage(foo));
    }

}
