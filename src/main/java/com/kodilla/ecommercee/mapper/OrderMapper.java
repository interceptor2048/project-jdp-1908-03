package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getStatus(),
                orderDto.getOrderDate(),
                orderDto.getSendDate(),
                orderDto.getDeliveredDate(),
                orderDto.getProducts(),
                userRepository.findById(orderDto.getUserId()).orElse(null)
        );
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getStatus(),
                order.getOrderDate(),
                order.getSendDate(),
                order.getDeliveredDate(),
                order.getProducts(),
                order.getUser().getId()
        );
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        return orders.stream()
                .map(n -> new OrderDto(n.getId(), n.getStatus(), n.getOrderDate(), n.getSendDate(), n.getDeliveredDate(), n.getProducts(), n.getUser().getId()))
                .collect(Collectors.toList());
    }
}
