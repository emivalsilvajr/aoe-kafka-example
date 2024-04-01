package com.aoc.kafka.example.demo.consumer;

import com.aoc.kafka.example.demo.domain.OrderEvent;
import com.aoc.kafka.example.demo.service.DeliveryService;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Component
public class DeliveryConsumer implements Consumer<OrderEvent> {

    private final DeliveryService deliveryService;


    public DeliveryConsumer(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @Override
    public void accept(OrderEvent orderEvent) {
        deliveryService.deliver(orderEvent);
    }
}
