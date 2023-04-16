/*
 * Copyright 2023 Complex calculator
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tests;

import utils.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Testing complex number class methods
 */
public class ComplexTest {
    @Test
    public void plus() {
        Complex a = new Complex(50, 11);
        Complex b = new Complex(25, 13);
        a.plus(b);
        assertTrue(a.getReal() == 75);
        assertTrue(a.getImag() == 24);
    }

    @Test
    public void minus() {
        Complex a = new Complex(60, 44);
        Complex b = new Complex(32, 11);
        a.minus(b);
        assertTrue(a.getReal() == 28);
        assertTrue(a.getImag() == 33);
    }

    @Test
    public void multiply() {
        Complex a = new Complex(10, 5);
        Complex b = new Complex(12, 10);
        a.multiply(b);
        assertTrue(a.getReal() == 70);
        assertTrue(a.getImag() == 160);
    }

    @Test
    public void divide() {
        Complex a = new Complex(12, 55);
        Complex b = new Complex(2, 4);
        a.divide(b);
        assertTrue(a.getReal() == 12.2);
        assertTrue(a.getImag() == 3.1);
    }

    @Test
    public void average() {
        Complex a = new Complex(4, 8);
        Complex b = new Complex(2, 4);
        a.average(b);
        assertTrue(a.getReal() == 3);
        assertTrue(a.getImag() == 6);
    }
}