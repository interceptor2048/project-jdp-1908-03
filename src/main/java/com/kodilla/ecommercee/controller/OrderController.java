package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Author Kamil Seweryn
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "v1/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(value = "getOrders")
    public List<Order> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam("orderId") Long orderId) {
        return new OrderDto(1L, "EXAMPLE");
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderRepository.save(new Order(orderDto.getName()));
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody Order order) {
        return new OrderDto(order.getId(), order.getName());
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam("orderId") Long orderId) {
        orderRepository.deleteById(orderId);
    }
}