package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/order")
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(value = "getOrders")
    public List<Order> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam("orderId") Long orderId) {
        return new OrderDto(1L, "EXAMPLE");
    }

    @PostMapping(value = "createOrder", consumes = "application/json")
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderRepository.save(new Order());
    }

    @PutMapping(value = "updateOrder", consumes = "application/json")
    public OrderDto updateOrder(@RequestBody OrderDto order) {
        return new OrderDto();
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam("orderId") Long orderId) {
        orderRepository.deleteById(orderId);
    }
}