package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order){
        return orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleted(Order order){
        orderRepository.delete(order);
    }

    public Order findById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}
