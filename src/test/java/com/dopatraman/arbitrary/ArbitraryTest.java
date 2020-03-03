package com.dopatraman.arbitrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbitraryTest {

    @Test
    void ofString() throws Exception {
        assertEquals("java.lang.String", Arbitrary.of(String.class).getClass().getName());
    }

    @Test
    void ofInt() throws Exception {
        assertEquals("java.lang.Integer", Arbitrary.of(Integer.class).getClass().getName());
    }

    @Test
    void ofComplex() throws Exception {
        assertNotNull(Arbitrary.of(Complex.Complex2.class));
    }
}