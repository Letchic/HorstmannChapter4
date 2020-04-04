package com.letchic.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintHelloWorld {
public static void print (){
    try {
        Field field = java.lang.System.class.getField("out");
        Object out = field.get(null);
        Method print = out.getClass().getMethod("println", String.class);
        print.invoke(out, "Hello, world!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
