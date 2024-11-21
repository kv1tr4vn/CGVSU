package com.cgvsu.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Matrix3X3Test {
    private Matrix3X3 defM;

    @BeforeEach
    void setUp() {
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        defM = new Matrix3X3(matrix);

    }


    @Test
    void sumWithPositiveNum() {
        double[][] matrixSum = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix3X3 mSum = new Matrix3X3(matrixSum);
        double[][] expectedResult = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);


        Matrix result = defM.sum(mSum);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }
    }

    @Test
    void sumWithNegativeNun() {
        double[][] matrixSum = {
                {-1, -2, -3},
                {-8, -10, -12},
                {-7, -16, -9}
        };
        Matrix3X3 mSum = new Matrix3X3(matrixSum);
        double[][] expectedResult = {
                {0, 0, 0},
                {-4, -5, -6},
                {0, -8, 0}
        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);


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
                {1, 2, 10},
                {4, 8, 6},
                {4, 8, 9}
        };
        Matrix3X3 mSub = new Matrix3X3(matrixSub);
        double[][] expectedResult = {
                {0, 0, -7},
                {0, -3, 0},
                {3, 0, 0}
        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);


        Matrix result = defM.subtract(mSub);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }

    }

    @Test
    void subtractWithNegativeNum() {
        double[][] matrixSub = {
                {-1, -2, -10},
                {-4, -8, -6},
                {-4, -8, -9}
        };
        Matrix3X3 mSub = new Matrix3X3(matrixSub);
        double[][] expectedResult = {
                {2, 4, 13},
                {8, 13, 12},
                {11, 16, 18}
        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);


        Matrix result = defM.subtract(mSub);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }

    }

    @Test
    void multiplyOnNullVector() {
        final double[] s = {0, 0, 0};
        Vector scalar = new Vector3(s);
        final double[] expRes = {0, 0, 0};
        Vector expectedResult = new Vector3(expRes);

        Vector result = defM.multiplyOnVector(scalar);

        assertEquals(expectedResult.getData(0), result.getData(0));
        assertEquals(expectedResult.getData(1), result.getData(1));
        assertEquals(expectedResult.getData(2), result.getData(2));


        for (int i = 0; i < expectedResult.length(); i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void multiplyOnVector() {
        final double[] s = {0.5, -0.5, 4};
        Vector scalar = new Vector3(s);
        final double[] mRes = {11.5, 23.5, 35.5};
        Vector expectedResult = new Vector3(mRes);

        Vector result = defM.multiplyOnVector(scalar);

        for (int i = 0; i < mRes.length; i++) {
            assertEquals(expectedResult.getData(i), result.getData(i));
        }
    }

    @Test
    void multiplyOnMatrixWithPositiveNum() {

        double[][] matrix2 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };

        Matrix3X3 m2 = new Matrix3X3(matrix2);

        double[][] expectedResult = {
                {14, 14, 14},
                {32, 32, 32},
                {50, 50, 50},

        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);


        Matrix result = defM.multiplyOnMatrix(m2);

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }

    }

    @Test
    void multiplyOnMatrixWithNegativeNum() {

        double[][] matrix2 = {
                {-1, -1, -1},
                {-2, -8, -2},
                {-3, -3, -13}
        };

        Matrix3X3 m2 = new Matrix3X3(matrix2);

        double[][] expectedResult = {
                {-14, -26, -44},
                {-32, -62, -92},
                {-50, -98, -140},

        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);


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
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);

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
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);

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
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        Matrix3X3 expectedRes = new Matrix3X3(expectedResult);

        Matrix result = defM.zero();

        for (int i = 0; i < expectedResult.length; i++) {
            for (int j = 0; j < expectedResult.length; j++) {
                assertEquals(expectedRes.getMatrix()[i][j], result.getMatrix()[i][j]);
            }
        }
    }
}