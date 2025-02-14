package com.example.demo.controller;

import com.example.demo.entities.Pizza;
import com.example.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping
    public Pizza creatPizza(@RequestBody Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    @GetMapping
    public List<Pizza> findAll(){
        return pizzaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pizza> findById(@PathVariable Long id){
        return pizzaRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        pizzaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
