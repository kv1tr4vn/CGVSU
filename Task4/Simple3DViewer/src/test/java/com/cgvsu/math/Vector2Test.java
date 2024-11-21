package com.cgvsu.math;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector2Test {

    @Test
    void sum() {
        final double[] m1 = {1, 2};
        final double[] m2 = {3, 4};

        Vector v1 = new Vector2(m1);
        Vector v2 = new Vector2(m2);

        final double[] mRes = {4, 6};
        Vector expectedResult = new Vector2(mRes);

        Vector result = v1.sum(v2);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }


    @Test
    void subtract() {
        final double[] m1 = {1, 4};
        final double[] m2 = {3, 2};

        Vector v1 = new Vector2(m1);
        Vector v2 = new Vector2(m2);

        final double[] mRes = {-2, 2};
        Vector expectedResult = new Vector2(mRes);

        Vector result = v1.subtract(v2);
        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void multiplyOnScalar() {
        final double[] m1 = {1, 2};
        Vector v1 = new Vector2(m1);
        double scalar = 5;
        final double[] mRes = {5, 10};
        Vector expectedResult = new Vector2(mRes);

        Vector result = v1.multiplyOnScalar(scalar);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void divisionOnScalar() {
        final double[] m1 = {1, 5};
        Vector v1 = new Vector2(m1);
        double scalar = 5;
        final double[] mRes = {0.2, 1};
        Vector expectedResult = new Vector2(mRes);

        Vector result = v1.divisionOnScalar(scalar);

        for (int i = 0; i < expectedResult.length(); i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void length() {
        final double[] m1 = {3, 4};
        Vector v1 = new Vector2(m1);
        double expectedResult = 5;

        double result = v1.length();

        assertEquals(expectedResult, result);

    }

    @Test
    void normalize() {
        final double[] m1 = {3, 4};
        Vector v1 = new Vector2(m1);
        final double[] mRes = {0.6, 0.8};
        Vector expectedResult = new Vector2(mRes);

        Vector result = v1.normalize();


        for (int i = 0; i < expectedResult.length(); i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void scalarProduct() {
        final double[] m1 = {1, 2};
        final double[] m2 = {4, 5};
        Vector v1 = new Vector2(m1);
        Vector v2 = new Vector2(m2);
        double expectedResult = 14;

        double result = v1.scalarProduct(v2);

        assertEquals(expectedResult, result);
    }
}