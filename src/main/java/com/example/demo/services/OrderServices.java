package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.enuns.StatusOrder;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public Boolean save(Order order){
        orderRepository.save(order);
        return true;
    }

    public Boolean deleteOrder(Long id){
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Boolean updateStatus(Long id, StatusOrder statusOrder){
        Order order = orderRepository.findById(id).orElse(null);
        if(order != null){
            order.setStatusOrder(statusOrder);
            return true;
        }
        return false;
    }
}