package com.cgvsu.math;


import java.util.Arrays;

public class Vector3 implements Vector {


    private final double[] data;

    public Vector3(double[] data) {
        if (data.length != 3) {
            throw new IllegalArgumentException("Данный вектор не правильной размерности(ожидается размер 3)");
        }
        this.data = data;
    }


    @Override
    public String toString() {
        return "Vector3{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public double getData(int index) {
        return data[index];
    }

    @Override
    public Vector3 sum(Vector other) {
        if (!(other instanceof Vector3)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 3)");
        }
        final double newX = getData(0) + other.getData(0);
        final double newY = getData(1) + other.getData(1);
        final double newZ = getData(2) + other.getData(2);
        final double[] newData = {newX, newY, newZ};
        return new Vector3(newData);
    }


    @Override
    public Vector3 subtract(Vector other) {
        if (!(other instanceof Vector3)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 3)");
        }
        final double newX = getData(0) - other.getData(0);
        final double newY = getData(1) - other.getData(1);
        final double newZ = getData(2) - other.getData(2);

        final double[] newData = {newX, newY, newZ};

        return new Vector3(newData);
    }

    @Override
    public Vector3 multiplyOnScalar(double scalar) {
        final double newX = getData(0) * scalar;
        final double newY = getData(1) * scalar;
        final double newZ = getData(2) * scalar;


        final double[] newData = {newX, newY, newZ};
        return new Vector3(newData);
    }

    @Override
    public Vector3 divisionOnScalar(double scalar) {
        final double newX = getData(0) / scalar;
        final double newY = getData(1) / scalar;
        final double newZ = getData(2) / scalar;


        final double[] newData = {newX, newY, newZ};
        return new Vector3(newData);
    }

    @Override
    public double length() {

        return Math.sqrt(Math.pow(getData(0), 2) + Math.pow(getData(1), 2) + Math.pow(getData(2), 2));
    }

    @Override
    public Vector3 normalize() {
        double length = length();
        if (length == 0) {
            throw new IllegalArgumentException("Нельзя нормализовать вектор с нулевой длиной");
        }
        final double newX = getData(0) / length;
        final double newY = getData(1) / length;
        final double newZ = getData(2) / length;


        final double[] newData = {newX, newY, newZ};
        return new Vector3(newData);
    }

    @Override
    public double scalarProduct(Vector other) {
        if (!(other instanceof Vector3)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 3)");
        }

        return getData(0) * other.getData(0) + getData(1) * other.getData(1) + getData(2) * other.getData(2);
    }


    //векторное произведение
    public Vector3 vectorProduct(Vector other) {
        if (!(other instanceof Vector3)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 3)");
        }
        double newX = getData(1) * other.getData(2) - other.getData(1) * getData(2);
        double newY = getData(0) * other.getData(2) - other.getData(0) * getData(2);
        double newZ = getData(0) * other.getData(1) - other.getData(0) * getData(1);


        final double[] newData = {newX, -newY, newZ};
        return new Vector3(newData);
    }


}

