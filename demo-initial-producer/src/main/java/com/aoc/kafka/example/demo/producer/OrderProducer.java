package com.aoc.kafka.example.demo.producer;

import com.aoc.kafka.example.demo.domain.OrderEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;


@Component
public class OrderProducer {

    private final StreamBridge streamBridge;


    public OrderProducer(StreamBridge streamBridge){
        this.streamBridge = streamBridge;
    }

    public void publish(OrderEvent event){
        streamBridge.send("new-order", event);
    }

}
