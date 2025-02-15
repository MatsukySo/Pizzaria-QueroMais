package com.example.demo.config;

import com.example.demo.controller.OrderController;
import com.example.demo.controller.PizzaController;
import com.example.demo.controller.UserController;
import com.example.demo.entities.Order;
import com.example.demo.entities.Pizza;
import com.example.demo.entities.User;
import com.example.demo.enuns.StatusOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserController userController;

    @Autowired
    private PizzaController pizzaController;

    @Autowired
    private OrderController orderController;

    @Override
    public void run(String... args) throws Exception {
        //Cardapio
        Pizza calabresa = new Pizza(null, "Calabresa", "Médio", 48.00);
        Pizza moaDaCasa = new Pizza(null, "Moda da casa", "Médio", 45.00);
        Pizza quatroQueijos = new Pizza(null, "Quatro queijos", "Médio", 50.00);
        Pizza peperone = new Pizza(null, "Peperone", "Médio", 40.00);
        Pizza doce = new Pizza(null, "Pizza Doce", "Médio", 38.00);
        Pizza bacon = new Pizza(null, "Bacon", "Médio", 40.00);

        pizzaController.save(calabresa);
        pizzaController.save(moaDaCasa);
        pizzaController.save(quatroQueijos);
        pizzaController.save(peperone);
        pizzaController.save(doce);
        pizzaController.save(bacon);

        //Cliente 1
        User user1 = new User(null, "Mateus Assis", "67999956470", "Rua Nao sei aonde");
        userController.saveUser(user1);

        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(calabresa);
        pizzaList.add(quatroQueijos);
        pizzaList.add(doce);

        Order order1 = new Order(null, user1, pizzaList, new Date(), StatusOrder.RECEIVED);
        orderController.saveOrder(order1);

        //Cliente 2
        User user2 = new User(null, "Felipe Rodrigues", "6745845554", "Rua do lado da outra");
        userController.saveUser(user2);

        List<Pizza> pizzaList2 = new ArrayList<>();
        pizzaList2.add(quatroQueijos);
        pizzaList2.add(moaDaCasa);
        pizzaList2.add(calabresa);

        Order order = new Order(null, user2, pizzaList2, new Date(), StatusOrder.RECEIVED);
        orderController.saveOrder(order);


    }
}
