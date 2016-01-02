package com.toyioc;


import com.toyioc.constructs.*;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class shouldResolve {

    private Resolver resolver;


    @Before
    public void setup() {
        resolver = new Resolver();
    }

    @Test
    public void concreteClassWithDefaultConstructor() {
        Object target = resolver.resolve(concreteClassWithDefaultConstructor.class);

        assertThat(target).isNotNull();
        assertThat(target).isInstanceOf(concreteClassWithDefaultConstructor.class);
    }

    @Test
    public void concreteClassWithOneConcreteConstructorArg() {
        concreteClassWithOneConcreteConstructorArg target = resolver.resolve(concreteClassWithOneConcreteConstructorArg.class);

        assertThat(target).isNotNull();
        assertThat(target.getArg1()).withFailMessage("did not inject arg1").isNotNull();
    }

    @Test
    public void concreteClassWithMultipleConcreteConstructorArgs() {
        concreteClassWithMultipleConcreteConstructorArgs target = resolver.resolve(concreteClassWithMultipleConcreteConstructorArgs.class);

        assertThat(target).isNotNull();
        assertThat(target.getArg1()).withFailMessage("did not inject arg1").isNotNull();
        assertThat(target.getArg2()).withFailMessage("did not inject arg2").isNotNull();
        assertThat(target.getArg3()).withFailMessage("did not inject arg3").isNotNull();

    }

    @Test
    public void concreteClassViaRegisteredInterface() {
        resolver.register(
                IRegisteredInterface.class,
                concreteClassWithInterface.class);
        Object target = resolver.resolve(IRegisteredInterface.class);

        assertThat(target).isNotNull();
        assertThat(target).isInstanceOf(concreteClassWithInterface.class);
    }

}

