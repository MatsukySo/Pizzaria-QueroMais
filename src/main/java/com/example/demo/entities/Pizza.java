package com.example.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_pizzas")
public class Pizza implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sabor;
    private Integer size;
    private Double price;

    public Pizza(Long id , String sabor, Integer size, Double price) {
        this.id = id;
        this.sabor = sabor;
        this.size = size;
        this.price = price;
    }

    public Pizza(){}

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
