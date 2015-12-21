package com.example.domainEvents;

import com.example.IDomainEvent;
import com.example.Person;

public class PersonAddedEvent implements IDomainEvent {

    private Person person;

    public PersonAddedEvent(Person person) {

        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
