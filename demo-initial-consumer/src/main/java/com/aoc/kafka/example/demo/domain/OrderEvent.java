package com.aoc.kafka.example.demo.domain;

public record OrderEvent(String eventName,OrderDetails details) {

}
