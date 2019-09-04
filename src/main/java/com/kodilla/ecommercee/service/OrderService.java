package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order getOrder(Long id) throws OrderNotFoundException {
        return  orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
