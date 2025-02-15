package com.example.demo.DTO;

import com.example.demo.entities.Order;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.User;
import java.util.List;

public class OrderDTO {
    private List<Pizza> pizzasList;
    private User user;

    public OrderDTO(Order order) {
        this.pizzasList = pizzasList;
        this.user = user;
    }

    public List<Pizza> getPizzasList() {
        return pizzasList;
    }

    public void setPizzasList(List<Pizza> pizzasList) {
        this.pizzasList = pizzasList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}