package com.homework.task2;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = new double[coeffs.length];
        System.arraycopy(coeffs, 0, this.coeffs, 0, coeffs.length);
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String polynom = "";
        for (int i = coeffs.length - 1; i > 1; i--)
            polynom += coeffs[i] + "x^" + i + " + ";
        polynom += coeffs[1] + "x + ";
        polynom += coeffs[0];

        return polynom;
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = coeffs.length - 1; i >= 0; i--)
            result += coeffs[i] * Math.pow(x, i);
        return result;
    }

    private void dropCoeffs(MyPolynomial polynomial, int i, double[] newCoeffs) {
        while (i < polynomial.getDegree() + 1) {
            newCoeffs[i] = polynomial.coeffs[i];
            i++;
        }
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxDegree = Math.max(this.getDegree(), right.getDegree());
        double[] newCoeffs = new double[maxDegree + 1];
        int i = 0;
        while (i < this.getDegree() + 1 && i < right.getDegree() + 1) {
            newCoeffs[i] = this.coeffs[i] + right.coeffs[i];
            i++;
        }

        dropCoeffs(this, i, newCoeffs);

        dropCoeffs(right, i, newCoeffs);

        return new MyPolynomial(newCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] newCoeffs = new double[this.getDegree() + right.getDegree() + 1];

        for (int i = 0; i < this.coeffs.length; i++)
            for (int j = 0; j < right.coeffs.length; j++)
                newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
        return new MyPolynomial(newCoeffs);
    }
}
