package com.dopatraman.arbitrary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimitiveTypeTest {

    @Test
    public void String() {
        assertEquals("java.lang.String", String.class.getName());
    }

    @Test
    public void Byte() {
        assertEquals("java.lang.Byte", Byte.class.getName());
    }

    @Test
    public void Short() {
        assertEquals("java.lang.Short", Short.class.getName());
    }

    @Test
    public void Integer() {
        assertEquals("java.lang.Integer", Integer.class.getName());
    }

    @Test
    public void Long() {
        assertEquals("java.lang.Long", Long.class.getName());
    }

    @Test
    public void Float() {
        assertEquals("java.lang.Float", Float.class.getName());
    }

    @Test
    public void Double() {
        assertEquals("java.lang.Double", Double.class.getName());
    }

    @Test
    public void Character() {
        assertEquals("java.lang.Character", Character.class.getName());
    }

    @Test
    public void Boolean() {
        assertEquals("java.lang.Boolean", Boolean.class.getName());
    }

    @Test
    public void _byte() {
        assertEquals("byte", byte.class.getName());
    }

    @Test
    public void _short() {
        assertEquals("short", short.class.getName());
    }

    @Test
    public void _int() {
        assertEquals("int", int.class.getName());
    }

    @Test
    public void _long() {
        assertEquals("long", long.class.getName());
    }

    @Test
    public void _float() {
        assertEquals("float", float.class.getName());
    }

    @Test
    public void _double() {
        assertEquals("double", double.class.getName());
    }

    @Test
    public void _char() {
        assertEquals("char", char.class.getName());
    }

    @Test
    public void _boolean() {
        assertEquals("boolean", boolean.class.getName());
    }
}
