package com.dopatraman.arbitrary;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ArbitraryString {
    public static String make(int size) {
        byte[] array = new byte[size]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
