package com.homework.task2;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;
    private double eps = 1e-6;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" +
                real +
                " + " + imag +
                "i)";
    }

    public boolean isReal() {
        return Math.abs(imag) < eps;
    }

    public boolean isImaginary() {
        return Math.abs(real) < eps;
    }

    public boolean equals(double real, double imag) {
        return Math.abs(this.real - real) < eps && Math.abs(this.imag - imag) < eps;
    }

    public boolean equals(MyComplex another) {
        return equals(another.getReal(), another.getImag());
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public double argument() {
        if (Math.abs(real) < eps && Math.abs(imag) < eps) {
            System.out.println("Cannot find argument of the number 0");
        } else {
            if (real > 0)
                return Math.atan(imag / real);
            else if (real < 0 && imag >= 0)
                return Math.atan(imag / real) + Math.PI;
            else if (real < 0 && imag < 0)
                return Math.atan(imag / real) - Math.PI;
        }
        return 0;
    }

    public MyComplex add(MyComplex right) {
        this.real += right.getReal();
        this.imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.getReal(), this.imag + right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.getReal();
        this.imag -= right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.getReal(), this.imag - right.getImag());
    }

    public MyComplex multiply(MyComplex right) {
        double r = this.real * right.getReal() - this.imag * right.getImag();
        double i = this.real * right.getImag() + this.imag * right.getReal();
        this.setValue(r, i);
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double l = this.real * right.getReal() + this.imag * right.getImag();
        double r = this.imag * right.getReal() - this.real * right.getImag();
        double del = Math.pow(right.getReal(), 2) + Math.pow(right.getImag(), 2);
        this.setValue(l / del, r / del);
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, -1 * this.imag);
    }
}
