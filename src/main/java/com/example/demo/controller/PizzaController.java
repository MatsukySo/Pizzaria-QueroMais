package com.example.demo.controller;

import com.example.demo.DTO.PizzaDTO;
import com.example.demo.entities.Pizza;
import com.example.demo.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Pizza pizza){
        Boolean saving = pizzaService.save(pizza);
        if(saving){
            return ResponseEntity.ok("Success!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleted(@PathVariable Long id){
        Boolean delete = pizzaService.deletePizza(id);
        if(delete){
            return ResponseEntity.ok("Success!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }

    @GetMapping
    public List<Pizza> findAll(){
        return pizzaService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<PizzaDTO> findById(@PathVariable Long id){
        Pizza pizza = pizzaService.findById(id);
        if(pizza != null){
            return ResponseEntity.ok(new PizzaDTO(pizza));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}/flavor")
    public ResponseEntity<String> updateFlavor(@PathVariable Long id, @RequestBody Map<String, String> request){
        String flavor = request.get("flavor");
        Boolean update = pizzaService.updateFlavor(id, flavor);
        if (update){
            return ResponseEntity.ok("Flavor Updated");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}/size")
    public ResponseEntity<String> updateSize(@PathVariable Long id, @RequestBody Map<String, String> request){
        String size = request.get("size");
        Boolean update = pizzaService.updateFlavor(id, size);
        if (update){
            return ResponseEntity.ok("Size Updated");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}/price")
    public ResponseEntity<String> updatePrice(@PathVariable Long id, @RequestBody Double price){
        Boolean update = pizzaService.updatePrice(id, price);
        if (update){
            return ResponseEntity.ok("Price Updated");
        }
        return ResponseEntity.notFound().build();
    }
}
