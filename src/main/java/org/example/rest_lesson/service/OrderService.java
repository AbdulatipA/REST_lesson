package org.example.rest_lesson.service;

import lombok.AllArgsConstructor;
import org.example.rest_lesson.Order;
import org.example.rest_lesson.exception.OrderNotFoundException;
import org.example.rest_lesson.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(long id) {
       return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Заказ не найден"));
    }

    public void delete(long id) {
       Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Заказ не найден"));
        orderRepository.delete(order);
    }

    public Order update(long id, Order order) {
        orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Заказ не найден"));
        order.setId(id);
        return orderRepository.save(order);
    }
}
