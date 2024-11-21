package com.cgvsu.math;


import java.util.Arrays;

public class Matrix3X3 implements Matrix {

    private final double[][] matrix;

    public Matrix3X3(double[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new IllegalArgumentException("Данная матрица не 3x3");
        }
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix3X3{\n");
        for (int i = 0; i < 3; i++) {
            sb.append("  ");
            sb.append(Arrays.toString(matrix[i]));
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }


    @Override
    public double[][] getMatrix() {
        return matrix;
    }

    @Override
    public Matrix sum(Matrix other) {
        final double[][] nevM = new double[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[i][j] + other.getMatrix()[i][j];
            }
        }
        return new Matrix3X3(nevM);
    }

    @Override
    public Matrix subtract(Matrix other) {
        final double[][] nevM = new double[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[i][j] - other.getMatrix()[i][j];
            }
        }
        return new Matrix3X3(nevM);
    }

    @Override
    public Vector multiplyOnVector(Vector vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }
        if (!(vector instanceof Vector3)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру");
        }

        final double newX = this.matrix[0][0] * vector.getData(0) + this.matrix[0][1] * vector.getData(1) + this.matrix[0][2] * vector.getData(2);
        final double newY = this.matrix[1][0] * vector.getData(0) + this.matrix[1][1] * vector.getData(1) + this.matrix[1][2] * vector.getData(2);
        final double newZ = this.matrix[2][0] * vector.getData(0) + this.matrix[2][1] * vector.getData(1) + this.matrix[2][2] * vector.getData(2);

        final double[] newData = {newX, newY, newZ};
        return new Vector3(newData);
    }

    @Override
    public Matrix multiplyOnMatrix(Matrix other) {
        double[][] nevM = new double[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[i][0] * other.getMatrix()[0][j] + matrix[i][1] * other.getMatrix()[1][j] + matrix[i][2] * other.getMatrix()[2][j];
            }
        }
        return new Matrix3X3(nevM);


    }

    @Override
    public Matrix transpose() {
        final double[][] nevM = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[j][i];
            }
        }
        return new Matrix3X3(nevM);
    }

    @Override
    public Matrix single() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return new Matrix3X3(matrix);
    }

    @Override
    public Matrix zero() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        return new Matrix3X3(matrix);
    }
}
