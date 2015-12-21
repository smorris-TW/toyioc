package com.example;

public class AggregateRoot {

    private static DomainEvents domainEvents = new DomainEvents();


    public DomainEvents getDomainEvents() { return domainEvents; }
}
