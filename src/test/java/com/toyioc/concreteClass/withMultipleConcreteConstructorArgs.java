package com.toyioc.concreteClass;

public class withMultipleConcreteConstructorArgs {

    private withDefaultConstructor arg1;
    private withDefaultConstructor arg2;
    private withDefaultConstructor arg3;

    public withMultipleConcreteConstructorArgs(
            withDefaultConstructor arg1,
            withDefaultConstructor arg2,
            withDefaultConstructor arg3
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
