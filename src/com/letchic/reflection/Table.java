package com.letchic.reflection;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class Table {
    public static void printTable(Method method, double lower, double upper, double step)
            throws IllegalAccessException, InvocationTargetException {
        if (method == null || !Modifier.isStatic(method.getModifiers())
                || method.getParameterTypes().length != 1
                || !(method.getParameterTypes()[0].equals(double.class))) {
            throw new IllegalArgumentException("Method must be of form AnyType SomeMethod(OneDouble)");
        }
        System.out.println(method.getDeclaringClass().getCanonicalName() + "." + method.getName());
        for (double value = lower; value <= upper; value += step) {
            Object result = method.invoke(method.getDeclaringClass(), value);
            System.out.println("Value: " + value + " returns: " + result);
        }
    }

    public static void printTableDoubleFucntion(DoubleFunction df, double lower, double upper, double step) {
        for (double value = lower; value <= upper; value += step) {
            Object result = df.apply(value);
            System.out.println("Value: " + value + " returns: " + result);
        }
    }
}
