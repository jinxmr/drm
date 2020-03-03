package com.ddl.test;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

public class Reflection {

    public static void main(String[] args) throws Exception
    {
        Class<?> aClass = Class.forName("com.ddl.test.Reflex");
        Reflex reflex = (Reflex) aClass.newInstance();
        System.out.println(reflex.publicMethod(2));
        Method method = aClass.getMethod("publicMethod", int.class);
        Object invoke = method.invoke(new Reflex(), 1);
        System.out.println(invoke);
    }
}