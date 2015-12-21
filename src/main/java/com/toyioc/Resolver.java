package com.toyioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Resolver {

    Logger log = LoggerFactory.getLogger(Resolver.class);

    public <T> T resolve(Class<T> targetType) {
        log.info(String.format("resolving '%s'", targetType.getName()));

        T targetObject = null;

        targetObject = resolveByDefaultConstructor(targetType);
        if (targetObject != null) return targetObject;

        targetObject = resolveByCustomConstructor(targetType);
        if (targetObject != null) return targetObject;

        targetObject = resolveByMap(targetType);
        if (targetObject != null) return targetObject;

        String message = String.format("Unable to resolve class '%s'", targetType.getName());
        throw new RuntimeException(message);


    }

    private <T> T resolveByDefaultConstructor(Class<T> targetType) {
        log.info(String.format("resolveByDefaultConstructor '%s'", targetType.getName()));
        try {
            return targetType.newInstance();
        } catch (InstantiationException e) {
            log.info("no default constructor");
        } catch (IllegalAccessException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    private <T> T resolveByCustomConstructor(Class<T> targetType) {
        log.info(String.format("resolveByCustomeConstructor '%s'", targetType.getName()));


        T newObject;

        Constructor[] constructors = targetType.getDeclaredConstructors();
        if (constructors.length == 0) return null;

        Constructor constructor = constructors[0];

        List<Object> args = new ArrayList<>();

        Class[] parameterTypes = constructor.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            args.add(resolve(parameterType));
        }

        try {
            newObject = (T) constructor.newInstance(args.toArray());
            String message = String.format("resolved '%s' using '%s'", targetType.getName(), constructor.toString());
            log.info(message);
            return newObject;
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            logAndThrow(e);
        }

        return null;
    }

    private <T> T resolveByMap(Class<T> targetType) {
        log.info(String.format("resolveByMap'%s'", targetType.getName()));


        Class implementationType = mappings.get(targetType);
        T targetObject = (T) resolve(implementationType);
        if (targetObject != null) return targetObject;

        return null;
    }


    private void logAndThrow(Exception e) {
        log.error(e.getMessage(), e);
        throw new RuntimeException(e);
    }

    private HashMap<Class, Class> mappings = new HashMap<>();

    public <I,C> void addMapping(
            Class<I> interfaceToRegister,
            Class<C> implementationClass) {

        mappings.put(interfaceToRegister, implementationClass);
    }
}
