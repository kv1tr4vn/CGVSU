package com.cgvsu.math;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector3Test {

    @Test
    void sum() {
        final double[] m1 = {1, 2, 4};
        final double[] m2 = {3, 4, 5};
        Vector v1 = new Vector3(m1);
        Vector v2 = new Vector3(m2);
        final double[] mRes = {4, 6, 9};
        Vector expectedResult = new Vector3(mRes);

        Vector result = v1.sum(v2);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void subtract() {
        final double[] m1 = {1, 4, 6};
        final double[] m2 = {3, 2, 0};
        Vector v1 = new Vector3(m1);
        Vector v2 = new Vector3(m2);
        final double[] mRes = {-2, 2, 6};
        Vector expectedResult = new Vector3(mRes);

        Vector result = v1.subtract(v2);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void multiplyOnScalar() {
        final double[] m1 = {1, 2, 8};
        Vector v1 = new Vector3(m1);
        final double scalar = 5;
        final double[] mRes = {5, 10, 40};
        Vector expectedResult = new Vector3(mRes);

        Vector result = v1.multiplyOnScalar(scalar);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }

    }

    @Test
    void divisionOnScalar() {
        final double[] m1 = {1, 5, 0};
        Vector v1 = new Vector3(m1);
        final double scalar = 5;
        final double[] mRes = {0.2, 1, 0};
        Vector expectedResult = new Vector3(mRes);

        Vector result = v1.divisionOnScalar(scalar);

        for (int i = 0; i < expectedResult.length(); i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void length() {
        final double[] m1 = {2, 1, 2};
        Vector v1 = new Vector3(m1);
        final double expectedResult = 3;

        final double result = v1.length();

        assertEquals(expectedResult, result);
    }

    @Test
    void normalize() {
        final double[] m1 = {2, 1, 2};
        Vector v1 = new Vector3(m1);
        final double[] mRes = {0.666, 0.333, 0.666};
        Vector expectedResult = new Vector3(mRes);

        Vector result = v1.normalize();

        for (int i = 0; i < expectedResult.length(); i++) {
            assertEquals(expectedResult.getData(i), result.getData(i), 0.001);
        }
    }

    @Test
    void scalarProduct() {
        final double[] m1 = {1, 2, 7};
        final double[] m2 = {4, 5, 6};
        Vector v1 = new Vector3(m1);
        Vector v2 = new Vector3(m2);
        final double expectedResult = 56;

        final double result = v1.scalarProduct(v2);

        assertEquals(expectedResult, result);
    }

    @Test
    void vectorProduct() {
        final double[] m1 = {1, 2, 7};
        final double[] m2 = {4, 5, 6};
        Vector3 v1 = new Vector3(m1);
        Vector3 v2 = new Vector3(m2);
        final double[] mRes = {-23, 22, -3};
        Vector expectedResult = new Vector3(mRes);

        Vector3 result = v1.vectorProduct(v2);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }
}