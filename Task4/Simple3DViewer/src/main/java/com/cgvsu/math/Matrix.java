package com.cgvsu.math;


public interface Matrix {
    Matrix sum(Matrix other);

    Matrix subtract(Matrix other);

    Vector multiplyOnVector(Vector vector);

    Matrix multiplyOnMatrix(Matrix matrix);

    Matrix transpose();

    Matrix single();

    Matrix zero();

    double[][] getMatrix();

}
