package com.example.demo.entities;

import com.example.demo.enuns.StatusOrder;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tb_orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="usuario_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_pizza",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private List<Pizza> pizzaList;

    private Date hourOrder;
    private StatusOrder statusOrder;
    public Order(Long id, User user, List<Pizza> pizzaList, Date hourOrder, StatusOrder statusOrder) {
        this.id = id;
        this.user = user;
        this.pizzaList = pizzaList;
        this.hourOrder = hourOrder;
        this.statusOrder = statusOrder;
    }

    public Order(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getHourOrder() {
        return hourOrder;
    }

    public void setHourOrder(Date hourOrder) {
        this.hourOrder = hourOrder;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizzaList = pizza;
    }

    public List<Pizza> getPizza() {
        return pizzaList;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }
}
