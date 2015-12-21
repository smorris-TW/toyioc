package com.example;

public interface IHandleDomainEvent<T> {

    void Handle(T domainEvent);
}
