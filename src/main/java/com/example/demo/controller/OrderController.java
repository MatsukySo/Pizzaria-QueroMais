package com.example.demo.controller;

import com.example.demo.entities.Order;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.User;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping
    public Order creatOrder(@RequestBody Order order){
        User user = userRepository.findById(order.getUser().getId()).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        List<Pizza> pizzas = order.getPizza().stream().map(p -> pizzaRepository.findById(p.getId())
                .orElseThrow(() -> new RuntimeException("Pizza não econtrada: ID " + p.getId()))).toList();

        order.setUser(user);
        order.setPizza(pizzas);

        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable Long id){
        return orderRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}