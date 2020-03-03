package com.dopatraman.arbitrary;

public class Complex {
    private String foo;

    public Complex() {}

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public static class Complex2 {
        private Complex complex;

        public Complex2() {}

        public Complex getComplex() {
            return complex;
        }

        public void setComplex(Complex complex) {
            this.complex = complex;
        }
    }
}
