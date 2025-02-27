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
    private String flavor;
    private String size;
    private Double price;

    public Pizza(Long id , String flavor, String size, Double price) {
        this.id = id;
        this.flavor = flavor;
        this.size = size;
        this.price = price;
    }

    public Pizza(){}

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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
