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
        T instance = t.getDeclaredConstructor().newInstance();
        Field[] fields = t.getDeclaredFields();
        for (Field f : fields) {
            // TODO: camel case string
            Method setter = t.getMethod("set" + f.getName(), f.getType());
            setter.invoke(instance, getArbitraryValue(f.getType()).constructArbitrary());
        }
        return instance;
    }

    public static <T> T ofBuilder(Class<T> t) {
        return null;
    }

    private static <T> ArbitraryTypeConstructor getArbitraryValue(Class<T> field) throws Exception {
        switch (field.getName()) {
            case "java.lang.String":
                return new ArbitraryString();
            default:
                return new ArbitraryString();
        }
    }
}
