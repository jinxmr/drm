package com.ddl.test;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Reflex implements Cloneable, Serializable {

    private String str;
    private double d;
    public boolean b;
    public static short s;

    public Reflex() {

    }

    public Reflex(String str) {
        this.str = str;
    }

    public Reflex(String str, double d, boolean b) {
        this.str = str;
        this.d = d;
        this.b = b;
    }

    private void privateMethod() {

    }

    public String publicMethod() {
        privateMethod();
        return null;
    }

    public String publicMethod(int i) {
        System.out.println(i);
        return String.valueOf(i);
    }

    public String publicMethod(int i, double d, List<String> l) {
        return "Reflection.publicMethod(int i, double d), i = " + i + ", d = " + d;
    }

    public static int returnOne() {
        return 1;
    }

    public String toString() {
        return "str = " + str + ", d = " + d + ", b = " + b;
    }
}
