package com.aoc.kafka.example.demo.restapi;

import com.aoc.kafka.dto.OrderRequest;
import com.aoc.kafka.dto.OrderResponse;
import com.aoc.kafka.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse request(@RequestBody OrderRequest request){
       return this.orderService.request(request);
    }
    
}
