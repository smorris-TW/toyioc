package com.toyioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Resolver {

    Logger log = LoggerFactory.getLogger(Resolver.class);

    public <T> T resolve(Class<T> targetClass) {
        log.info(String.format("resolving '%s'", targetClass.getName()));

        T targetObject = null;

        targetObject = resolveByDefaultConstructor(targetClass);
        if (targetObject != null) return targetObject;

        targetObject = resolveByCustomConstructor(targetClass);
        if (targetObject != null) return targetObject;

        String message = String.format("Unable to resolve class '%s'", targetClass.getName());
        throw new RuntimeException(message);


    }

    private <T> T resolveByDefaultConstructor(Class<T> targetClass) {
        try {
            return targetClass.newInstance();
        } catch (InstantiationException e) {
            log.info("no default constructor");
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    private <T> T resolveByCustomConstructor(Class<T> targetClass) {
        T newObject;

        Constructor[] constructors = targetClass.getDeclaredConstructors();
        Constructor constructor = constructors[0];

        List<Object> args = new ArrayList<>();

        Class[] parameterTypes = constructor.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            args.add(resolve(parameterType));
        }

        try {
            newObject = (T) constructor.newInstance(args.toArray());
            String message = String.format("resolved '%s' using '%s'", targetClass.getName(), constructor.toString());
            log.info(message);
            return newObject;
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            logAndThrow(e);
        }

        return null;
    }

    private void logAndThrow(Exception e) {
        log.error(e.getMessage(), e);
        throw new RuntimeException(e);
    }
}
