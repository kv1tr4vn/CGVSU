package com.cgvsu.math;

import java.util.Arrays;

public class Matrix4X4 implements Matrix {

    private final double[][] matrix;

    public Matrix4X4(double[][] matrix) {
        if (matrix.length != 4 || matrix[0].length != 4) {
            throw new IllegalArgumentException("Данная матрица не 4x4");
        }
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix4X4{\n");
        for (int i = 0; i < 4; i++) {
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
        final double[][] nevM = new double[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[i][j] + other.getMatrix()[i][j];
            }
        }
        return new Matrix4X4(nevM);
    }

    @Override
    public Matrix subtract(Matrix other) {
        final double[][] nevM = new double[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[i][j] - other.getMatrix()[i][j];
            }
        }
        return new Matrix4X4(nevM);
    }

    @Override
    public Vector multiplyOnVector(Vector vector) {
        if (vector == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }
        if (!(vector instanceof Vector4)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру");
        }


        final double newX = this.matrix[0][0] * vector.getData(0) + this.matrix[0][1] * vector.getData(1) + this.matrix[0][2] * vector.getData(2) + this.matrix[0][3] * vector.getData(3);
        final double newY = this.matrix[1][0] * vector.getData(0) + this.matrix[1][1] * vector.getData(1) + this.matrix[1][2] * vector.getData(2) + this.matrix[1][3] * vector.getData(3);
        final double newZ = this.matrix[2][0] * vector.getData(0) + this.matrix[2][1] * vector.getData(1) + this.matrix[2][2] * vector.getData(2) + this.matrix[2][3] * vector.getData(3);
        final double newW = this.matrix[3][0] * vector.getData(0) + this.matrix[3][1] * vector.getData(1) + this.matrix[3][2] * vector.getData(2) + this.matrix[3][3] * vector.getData(3);
        final double[] newData = {newX, newY, newZ, newW};
        return new Vector4(newData);
    }

    @Override
    public Matrix multiplyOnMatrix(Matrix other) {
        final double[][] nevM = new double[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[i][0] * other.getMatrix()[0][j] + matrix[i][1] * other.getMatrix()[1][j] + matrix[i][2] * other.getMatrix()[2][j] + matrix[i][3] * other.getMatrix()[3][j];
            }
        }
        return new Matrix4X4(nevM);


    }

    @Override
    public Matrix transpose() {
        final double[][] nevM = new double[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nevM[i][j] = matrix[j][i];
            }
        }
        return new Matrix4X4(nevM);
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
        return new Matrix4X4(matrix);
    }

    @Override
    public Matrix zero() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        return new Matrix4X4(matrix);
    }
}
