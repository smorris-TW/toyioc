package com.example.eventHandlers.whenAPersonIsAdded;


import com.example.IHandleDomainEvent;
import com.example.domainEvents.PersonAddedEvent;

public class SendWelcomeEmail
        implements IHandleDomainEvent<PersonAddedEvent> {

    @Override
    public void Handle(PersonAddedEvent domainEvent) {

    }
}
