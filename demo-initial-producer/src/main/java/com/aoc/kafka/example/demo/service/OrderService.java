package com.aoc.kafka.example.demo.service;

import com.aoc.kafka.example.demo.dto.OrderRequest;
import com.aoc.kafka.example.demo.dto.OrderResponse;
import com.aoc.kafka.example.demo.domain.OrderDetails;
import com.aoc.kafka.example.demo.domain.OrderEvent;
import com.aoc.kafka.example.demo.producer.OrderProducer;
import java.util.UUID;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final OrderProducer orderProducer;

    public OrderService(OrderProducer orderProducer){
        this.orderProducer = orderProducer;
    }

    public OrderResponse request(OrderRequest request){
        String id =  UUID.randomUUID().toString();
        OrderDetails details = new OrderDetails(id, request.itemId(), request.quantity());
        OrderEvent event = new OrderEvent("ORDER_WAS_REQUESTED", details);
        orderProducer.publish(event);
        return new OrderResponse(id);
    }

}
