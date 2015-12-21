package com.toyioc;


import com.toyioc.concreteClass.withDefaultConstructor;
import com.toyioc.concreteClass.withMultipleConcreteConstructorArgs;
import com.toyioc.concreteClass.withOneConcreteConstructorArg;
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
        Object target = resolver.resolve(withDefaultConstructor.class);

        assertThat(target).isNotNull();
        assertThat(target).isInstanceOf(withDefaultConstructor.class);
    }

    @Test
    public void concreteClassWithOneConcreteConstructorArg() {
        withOneConcreteConstructorArg target = resolver.resolve(withOneConcreteConstructorArg.class);

        assertThat(target).isNotNull();
        assertThat(target.getArg1()).withFailMessage("did not inject arg1").isNotNull();
    }

    @Test
    public void concreteClassWithMultipleConcreteConstructorArgs() {
        withMultipleConcreteConstructorArgs target = resolver.resolve(withMultipleConcreteConstructorArgs.class);

        assertThat(target).isNotNull();
        assertThat(target.getArg1()).withFailMessage("did not inject arg1").isNotNull();
        assertThat(target.getArg2()).withFailMessage("did not inject arg2").isNotNull();
        assertThat(target.getArg3()).withFailMessage("did not inject arg3").isNotNull();

    }

}

