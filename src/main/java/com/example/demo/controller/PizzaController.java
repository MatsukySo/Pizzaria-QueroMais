package com.example.demo.controller;

import com.example.demo.entities.Pizza;
import com.example.demo.repository.PizzaRepository;
import com.example.demo.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;
    
}
