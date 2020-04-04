package com.letchic.reflection;

import java.lang.reflect.Method;

public class Test {
    private static final int ITERATIONS = 10000000;
    private static int myMin(int x, int y) {
        return x < y ? x : y;
    }
    public static int testDirect(int v) {
        int result = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            result += myMin(1000, v);
        }
        return result;
    }

    public static int testReflection(int v, Method m) throws Throwable {
        int result = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            result += (int) m.invoke(null, 1000, v);
        }
        return result;
    }
}
