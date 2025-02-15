package com.example.demo.controller;

import com.example.demo.DTO.OrderDTO;
import com.example.demo.entities.Order;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.User;
import com.example.demo.enuns.StatusOrder;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        Boolean saving = orderServices.save(order);
        if (saving){
            return ResponseEntity.ok("Success!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Save Failed");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Boolean deleting = orderServices.deleteOrder(id);
        if (deleting){
            return ResponseEntity.ok("Deleted success!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Failed");
    }

    @GetMapping
    public List<Order> findAll(){
        return orderServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
        Order order =  orderServices.findById(id);
        if(order != null){
            return ResponseEntity.ok(new OrderDTO(order));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/updateStatus")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody StatusOrder statusOrder){
        Boolean update = orderServices.updateStatus(id, statusOrder);
        if(update){
            return ResponseEntity.ok("Update Success!");
        }
        return ResponseEntity.notFound().build();
    }
}