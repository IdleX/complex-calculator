package tests;

import utils.*;
import static org.junit.Assert.*;

public class ComplexTest {
    @org.junit.Test
    public void plus() {
        Complex a = new Complex(50, 11);
        Complex b = new Complex(25, 13);
        a.plus(b);
        assertTrue(a.getReal() == 75);
        assertTrue(a.getImag() == 24);
    }

    @org.junit.Test
    public void minus() {
        Complex a = new Complex(60, 44);
        Complex b = new Complex(32, 11);
        a.minus(b);
        assertTrue(a.getReal() == 28);
        assertTrue(a.getImag() == 33);
    }

    @org.junit.Test
    public void multiply() {
        Complex a = new Complex(10, 5);
        Complex b = new Complex(12, 10);
        a.multiply(b);
        assertTrue(a.getReal() == 70);
        assertTrue(a.getImag() == 160);
    }

    @org.junit.Test
    public void divide() {
        Complex a = new Complex(12, 55);
        Complex b = new Complex(2, 4);
        a.divide(b);
        assertTrue(a.getReal() == 12.2);
        assertTrue(a.getImag() == 3.1);
    }
}