package com.example.demo.DTO;

import com.example.demo.entities.Order;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.User;
import java.util.List;

public class OrderDTO {
    private List<Pizza> pizzasList;
    private Double sum;

    public OrderDTO(Order order) {
        this.pizzasList = pizzasList;
        this.sum = sum;
    }

    public List<Pizza> getPizzasList() {
        return pizzasList;
    }

    public Double getSum() {
        return sum;
    }
}