package com.cgvsu.math;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Matrix4X4Test {
    private Matrix4X4 defM;

    @BeforeEach
    void setUp() {
        double[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        defM = new Matrix4X4(matrix);

    }


    @Test
    void sumWithPositiveNum() {
        double[][] matrixSum = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Matrix4X4 mSum = new Matrix4X4(matrixSum);
        double[][] expectedResult = {
                {2, 4, 6, 8},
                {10, 12, 14, 16},
                {18, 20, 22, 24},
                {26, 28, 30, 32}
        };
        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);


        Matrix result = defM.sum(mSum);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void sumWithNegativeNum() {
        double[][] matrixSum = {
                {-1, -2, -3, -4},
                {-10, -16, -1, -14.5},
                {-1, -23, -((double) 1 / 2), -10},
                {-130, -52, -0, -44.5}
        };
        Matrix4X4 mSum = new Matrix4X4(matrixSum);
        double[][] expectedResult = {
                {0, 0, 0, 0},
                {-5, -10, 6, -6.5},
                {8, -13, 10.5, 2},
                {-117, -38, 15, -28.5}
        };
        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);


        Matrix result = defM.sum(mSum);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void subtractWithPositiveNum() {
        double[][] matrixSub = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {5, 10, 11, 15},
                {13, 14.5, 17, 16}
        };
        Matrix4X4 mSub = new Matrix4X4(matrixSub);
        double[][] expectedResult = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, -3},
                {0, -0.5, -2, 0}
        };
        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);


        Matrix result = defM.subtract(mSub);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }

    }

    @Test
    void multiplyOnVector() {
        final double[] s = {0.3, -0.5, 14, -3};
        final double[] mRes = {29.299, 72.5, 115.699, 158.9};
        Vector scalar = new Vector4(s);
        Vector expectedResult = new Vector4(mRes);

        Vector result = defM.multiplyOnVector(scalar);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i), 0.001);
        }
    }

    @Test
    void multiplyOnNullVector() {
        final double[] s = {0, 0, 0, 0};
        Vector scalar = new Vector4(s);
        final double[] mRes = {0, 0, 0, 0};
        Vector expectedResult = new Vector4(mRes);

        Vector result = defM.multiplyOnVector(scalar);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void multiplyOnMatrixWithPositiveMum() {

        double[][] matrix2 = {
                {1, 1, 1, 0.5},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 2, 4, 4}
        };

        Matrix4X4 m2 = new Matrix4X4(matrix2);

        double[][] expectedResult = {
                {30, 22, 30, 29.5},
                {70, 54, 70, 67.5},
                {110, 86, 110, 105.5},
                {150, 118, 150, 143.5}
        };
        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);


        Matrix result = defM.multiplyOnMatrix(m2);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }

    }

    @Test
    void multiplyOnMatrixWithNegativeMum() {

        double[][] matrix2 = {
                {-1, -10, 0, -0.5},
                {-2, -2, -2, -2},
                {-300, -15, -155.0, -3},
                {-44, -0.3, -6, -4}
        };

        Matrix4X4 m2 = new Matrix4X4(matrix2);

        double[][] expectedResult = {
                {-1081, -60.2, -493, -29.5},
                {-2469, -169.4, -1145, -67.5},
                {-3857, -278.6, -1797, -105.5},
                {-5245, -387.8, -2449, -143.5}
        };
        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);


        Matrix result = defM.multiplyOnMatrix(m2);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }

    }


    @Test
    void transpose() {

        double[][] expectedResult = {
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        };

        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);

        Matrix result = defM.transpose();


        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void single() {
        double[][] expectedResult = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);

        Matrix result = defM.single();

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void zero() {
        double[][] expectedResult = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0,}
        };
        Matrix4X4 expectedRes = new Matrix4X4(expectedResult);

        Matrix result = defM.zero();

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }
    }
}