package com.example.demo.services;

import com.example.demo.entities.Pizza;
import com.example.demo.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Boolean save(Pizza pizza){
        pizzaRepository.save(pizza);
        return true;
    }

    public Boolean deletePizza(Long id){
        if(pizzaRepository.existsById(id)){
            pizzaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Pizza> findAll(){
        return pizzaRepository.findAll();
    }

    public Pizza findById(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }

    public Boolean updateFlavor(Long id, String sabor){
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        if (pizza != null){
            pizza.setFlavor(sabor);
            return true;
        }
        return false;
    }

    public Boolean updateSize(Long id, String size){
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        if(pizza != null){
            pizza.setSize(size);
            return true;
        }
        return false;
    }

    public Boolean updatePrice(Long id, Double price){
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        if(pizza != null){
            pizza.setPrice(price);
            return true;
        }
        return false;
    }
}
