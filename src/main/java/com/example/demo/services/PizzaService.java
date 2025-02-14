package com.example.demo.services;

import com.example.demo.entities.Pizza;
import com.example.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza save(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    @DeleteMapping("/{id}")
    public void deleted(Long id){
        pizzaRepository.deleteById(id);
    }

    public Pizza findById(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }
}
