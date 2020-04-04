package com.letchic.reflection.methods;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class AllMethods {
    public static void printMethod(Object obj) {
        Class<?> cl = obj.getClass();
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                                m.getReturnType().getCanonicalName() + " " +
                                m.getName() +
                                Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }
}
