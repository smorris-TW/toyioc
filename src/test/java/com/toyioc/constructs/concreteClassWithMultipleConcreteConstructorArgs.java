package com.toyioc.constructs;

public class concreteClassWithMultipleConcreteConstructorArgs {

    private concreteClassWithDefaultConstructor arg1;
    private concreteClassWithDefaultConstructor arg2;
    private concreteClassWithDefaultConstructor arg3;

    public concreteClassWithMultipleConcreteConstructorArgs(
            concreteClassWithDefaultConstructor arg1,
            concreteClassWithDefaultConstructor arg2,
            concreteClassWithDefaultConstructor arg3
    ) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
    }

    public Object getArg1() {
        return arg1;
    }

    public Object getArg2() {
        return arg2;
    }

    public Object getArg3() {
        return arg3;
    }
}
