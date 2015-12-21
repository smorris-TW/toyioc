package com.toyioc;


import com.toyioc.concreteClass.withDefaultConstructor;
import com.toyioc.concreteClass.withMultipleConcreteConstructorArgs;
import com.toyioc.concreteClass.withOneConcreteConstructorArg;
import com.toyioc.interfaces.IRegisteredInterface;
import com.toyioc.interfaces.ImplementsIRegisteredInterface;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class shouldMap {

    private Resolver resolver;


    @Before
    public void setup() {
        resolver = new Resolver();
    }

    @Test
    public void interfaceToRegisteredClass() {
        resolver.addMapping(
                IRegisteredInterface.class,
                ImplementsIRegisteredInterface.class);
        Object target = resolver.resolve(IRegisteredInterface.class);

        assertThat(target).isNotNull();
        assertThat(target).isInstanceOf(ImplementsIRegisteredInterface.class);
    }


}

