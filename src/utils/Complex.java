package utils;

import java.text.*;
import java.util.*;

public class Complex {
  private double re; // the real part
  private double im; // the imaginary part

  /**
   * Create a new object with the given real and imaginary parts
   * 
   * @param real a complex number real part
   * @param imag a complex number imaginary part
  */
  public Complex(double real, double imag) {
    re = real;
    im = imag;
  }

  /**
   * Add operation
   * 
   * @param b summand
   * @return this Complex object whose value is (this + b)
  */
  public Complex plus(Complex b) {
    re += b.re;
    im += b.im;
    return this;
  }

  /**
   * Remove operation
   * 
   * @param b subtrahend
   * @return this Complex object whose value is (this - b)
  */
  public Complex minus(Complex b) {
    re -= b.re;
    im -= b.im;
    return this;
  }

  /**
   * Multiply operation
   * 
   * @param b multiplier
   * @return this Complex object whose value is (this * b)
  */
  public Complex multiply(Complex b) {
    double real = re * b.re - im * b.im;
    double imag = re * b.im + im * b.re;
    re = real;
    im = imag;
    return this;
  }

  /**
   * Divide operation
   * 
   * @param b divider
   * @return this Complex object whose value is (this / b)
  */
  public Complex divide(Complex b) {
    if (b.re == 0 && b.im == 0) {
      throw new ArithmeticException("На ноль делить нельзя");
    }

    double real = (re * b.re + im * b.im) / (b.re * b.re + b.im * b.im);
    double imag = (im * b.re - re * b.im) / (b.re * b.re + b.im * b.im);
    re = real;
    im = imag;
    return this;
  }

  /**
   * Average operation
   * 
   * @param b summand
   * @return this Complex object whose value is ((this + b) / 2)
  */
  public Complex average(Complex b) {
    re = (re + b.re) / 2;
    im = (im + b.im) / 2;
    return this;
  }

  /**
   * Returns the real component of the Complex object
   *
   * @return the double value associated with the real component
  */
  public double getReal() {
    return re;
  }

  /**
   * Returns the imaginary component of the Complex object
   *
   * @return the double value associated with the imaginary component
  */
  public double getImag() {
    return im;
  }

  /**
   * Returns Complex object in string
   *
   * @return this Complex object in string
  */
  public String toString() {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
    symbols.setDecimalSeparator('.');
    DecimalFormat dec = new DecimalFormat("#.#########", symbols);
		return dec.format(re) + " + " + dec.format(im) + "i";
	}
}