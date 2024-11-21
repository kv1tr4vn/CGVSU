package com.cgvsu.math;


public interface Vector {

    double getData(int index);

    Vector sum(Vector other);

    Vector subtract(Vector other);

    Vector multiplyOnScalar(double scalar);

    Vector divisionOnScalar(double scalar);

    double length();

    Vector normalize();

    //скалярное произведение
    double scalarProduct(Vector other);

}