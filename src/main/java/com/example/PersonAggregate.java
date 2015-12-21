package com.example;


import com.example.domainEvents.PersonAddedEvent;

import java.util.ArrayList;
import java.util.List;

public class PersonAggregate extends AggregateRoot {

    private List<Person> list = new ArrayList<>();

    public void add(String name) {
        Person person = new Person(name);
        list.add(person);

        getDomainEvents().raise(new PersonAddedEvent(person));
    }
}

