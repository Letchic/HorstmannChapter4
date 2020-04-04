package com.letchic.reflection.tostring;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class UniversalToString {
    public static String toString(Object obj) {
        StringBuffer sb = new StringBuffer();
        String newline = "";

        for (Field f: obj.getClass().getDeclaredFields()) {
            int mod = f.getModifiers();
            if (Modifier.isStatic(mod)) {
                continue;
            }
            f.setAccessible(true);
            try {
                Object value = f.get(obj);
                sb.append(newline + Modifier.toString(mod) + " " + f.getType().getSimpleName() + " " + f.getName() + ":" + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            newline = "\n";
        }
        return sb.toString();
    }
}
