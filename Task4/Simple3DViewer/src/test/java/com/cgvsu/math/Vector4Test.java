package com.cgvsu.math;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Vector4Test {

    @Test
    void sum() {
        final double[] m1 = {1, 2, 4, 0};
        final double[] m2 = {3, 4, 5, 7};
        Vector v1 = new Vector4(m1);
        Vector v2 = new Vector4(m2);
        final double[] mRes = {4, 6, 9, 7};
        Vector expectedResult = new Vector4(mRes);

        Vector result = v1.sum(v2);
        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }
    @Test
    void subtract() {
        final double[] m1 = {1, 4, 6, 0};
        final double[] m2 = {3, 2, 0, 7};
        Vector v1 = new Vector4(m1);
        Vector v2 = new Vector4(m2);
        final double[] mRes = {-2, 2, 6, -7};
        Vector expectedResult = new Vector4(mRes);

        Vector result = v1.subtract(v2);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void multiplyOnScalar() {
        final double[] m1 = {1, -2, 8, 0};
        Vector v1 = new Vector4(m1);
        double scalar = 5;
        final double[] mRes = {5, -10, 40, 0};
        Vector expectedResult = new Vector4(mRes);

        Vector result = v1.multiplyOnScalar(scalar);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void divisionOnScalar() {
        final double[] m1 = {1, 5, 0, 10};
        Vector v1 = new Vector4(m1);
        double scalar = 5;
        final double[] mRes = {0.2, 1, 0, 2};
        Vector expectedResult = new Vector4(mRes);

        Vector result = v1.divisionOnScalar(scalar);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void length() {
        final double[] m1 = {1, 4, 2, 2};
        Vector v1 = new Vector4(m1);
        double expectedResult = 5;

        double result = v1.length();

        assertEquals(expectedResult, result);
    }

    @Test
    void normalize() {
        final double[] m1 = {1, 4, 2, 2};
        Vector v1 = new Vector4(m1);
        final double[] mRes = {0.2, 0.8, 0.4, 0.4};
        Vector expectedResult = new Vector4(mRes);

        Vector result = v1.normalize();

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void scalarProduct() {
        final double[] m1 = {1, 2, 7, 4};
        final double[] m2 = {4, 5, 6, 0};
        Vector v1 = new Vector4(m1);
        Vector v2 = new Vector4(m2);
        double expectedResult = 56;

        double result = v1.scalarProduct(v2);

        assertEquals(expectedResult, result);
    }


}