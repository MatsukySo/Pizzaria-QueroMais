package com.example.demo.DTO;

import com.example.demo.entities.Pizza;

public class PizzaDTO {
    private String name;
    private Integer size;
    private Double price;

    public PizzaDTO(Pizza pizza) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }
}
