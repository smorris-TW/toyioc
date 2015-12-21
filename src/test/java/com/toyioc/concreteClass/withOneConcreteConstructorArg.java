package com.toyioc.concreteClass;

public class withOneConcreteConstructorArg {

    private withDefaultConstructor arg1;

    public withOneConcreteConstructorArg(withDefaultConstructor arg1) {
        this.arg1 = arg1;
    }

    public Object getArg1() {
        return arg1;
    }
}


