package com.example;

import com.example.domainEvents.PizzaAddedEvent;

import java.util.ArrayList;
import java.util.List;

public class PizzaAggregate extends AggregateRoot {
    private List<Pizza> list = new ArrayList<>();

    public void add(String name) {
        Pizza pizza = new Pizza(name);
        list.add(pizza);

        getDomainEvents().raise(new PizzaAddedEvent(pizza));
    }
}
