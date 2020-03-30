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

    // This construction assumes two things:
    // 1. That each field has a setter that is suffixed with its name
    // 2. That fields are set by the setter (as in not set by a constructor)
    // This will likely break for values injected into a constructor.
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
            case "java.lang.Byte":
            case "byte":
            case "java.lang.Short":
            case "short":
            case "java.lang.Integer":
            case "int":
            case "java.lang.Long":
            case "long":
            case "java.lang.Float":
            case "float":
            case "java.lang.Double":
            case "double":
            case "java.lang.Character":
            case "char":
            case "java.lang.String":
            case "java.lang.Boolean":
            case "boolean":
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
