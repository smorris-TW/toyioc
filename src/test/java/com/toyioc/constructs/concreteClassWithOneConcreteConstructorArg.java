package com.toyioc.constructs;

public class concreteClassWithOneConcreteConstructorArg {

    private concreteClassWithDefaultConstructor arg1;

    public concreteClassWithOneConcreteConstructorArg(concreteClassWithDefaultConstructor arg1) {
        this.arg1 = arg1;
    }

    public Object getArg1() {
        return arg1;
    }
}


