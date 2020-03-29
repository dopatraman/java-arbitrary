package com.dopatraman.arbitrary;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Arbitrary {
    // NOTE: This method requires the target class to have
    // a noargs constructor
    public static <T> T of(Class<T> t) throws Exception {
        // instantiate obj with noargs constructor
        // get all declared fields from generic
        // for each field, call setter on instance with new value
        // return
        return isPrimitive(t)
                ? (T) constructArbitrary(t)
                : (T) constructArbitraryForEachField(t);
    }

    private static <T> Object constructArbitraryForEachField(Class<T> t) throws Exception {
        T instance = t.getConstructor().newInstance();
        Field[] fields = t.getDeclaredFields();
        for (Field f : fields) {
            Method setter = t.getMethod("set" + capitalize(f.getName()), f.getType());
            setter.invoke(instance, constructArbitrary(f.getType()));
        }
        return instance;
    }

    private static <T> boolean isPrimitive(Class<T> c) throws Exception {
        switch(c.getName()) {
            case "java.lang.String":
            case "java.lang.Integer":
                return true;
            default:
                return false;
        }
    }

    private static <T> Object constructArbitrary(Class<T> field) throws Exception {
        switch(field.getName()) {
            case "java.lang.String":
                return ArbitraryString.make(10);
            case "java.lang.Integer":
                return ArbitraryInteger.make();
            default:
                return Arbitrary.of(field);
        }
    }

    private static String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
