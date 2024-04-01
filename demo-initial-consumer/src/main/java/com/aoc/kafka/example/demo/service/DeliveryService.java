package com.aoc.kafka.example.demo.service;

import com.aoc.kafka.example.demo.dto.OrderRequest;
import com.aoc.kafka.example.demo.dto.OrderResponse;
import com.aoc.kafka.example.demo.domain.OrderDetails;
import com.aoc.kafka.example.demo.domain.OrderEvent;
import com.aoc.kafka.example.demo.producer.DeliveryProducer;
import java.util.UUID;
import org.springframework.stereotype.Service;


@Service
public class DeliveryService {

    private final DeliveryProducer deliveryProducer;

    public DeliveryService(DeliveryProducer deliveryProducer){
        this.deliveryProducer = deliveryProducer;
    }

    public void deliver(OrderEvent request){
        OrderEvent event = new OrderEvent("DELIVERY_WAS_CONFIRMED", request.details());
        deliveryProducer.publish(event);
    }

}
