package com.example.domainEvents;


import com.example.IDomainEvent;
import com.example.Pizza;

public class PizzaAddedEvent implements IDomainEvent {
    private Pizza pizza;

    public PizzaAddedEvent(Pizza pizza) {
        this.pizza = pizza;
    }
}
