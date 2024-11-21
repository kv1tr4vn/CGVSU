package com.cgvsu.math;

import java.util.Arrays;

public class Vector4 implements Vector {
    private final double[] data;

    public Vector4(double[] data) {
        if (data.length != 4) {
            throw new IllegalArgumentException("Данный вектор не правильной размерности(ожидается размер 4)");
        }
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vector4{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public double getData(int index) {
        return data[index];
    }

    @Override
    public Vector4 sum(Vector other) {
        if (!(other instanceof Vector4)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 4)");
        }
        final double newX = getData(0) + other.getData(0);
        final double newY = getData(1) + other.getData(1);
        final double newZ = getData(2) + other.getData(2);
        final double newW = getData(3) + other.getData(3);

        final double[] newData = {newX, newY, newZ, newW};
        return new Vector4(newData);
    }


    @Override
    public Vector4 subtract(Vector other) {
        if (!(other instanceof Vector4)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 4)");
        }
        final double newX = getData(0) - other.getData(0);
        final double newY = getData(1) - other.getData(1);
        final double newZ = getData(2) - other.getData(2);
        final double newW = getData(3) - other.getData(3);

        final double[] newData = {newX, newY, newZ, newW};
        return new Vector4(newData);
    }

    @Override
    public Vector4 multiplyOnScalar(double scalar) {
        final double newX = getData(0) * scalar;
        final double newY = getData(1) * scalar;
        final double newZ = getData(2) * scalar;
        final double newW = getData(3) * scalar;

        final double[] newData = {newX, newY, newZ, newW};
        return new Vector4(newData);

    }

    @Override
    public Vector4 divisionOnScalar(double scalar) {
        final double newX = getData(0) / scalar;
        final double newY = getData(1) / scalar;
        final double newZ = getData(2) / scalar;
        final double newW = getData(3) / scalar;

        final double[] newData = {newX, newY, newZ, newW};
        return new Vector4(newData);
    }

    @Override
    public double length() {

        return Math.sqrt(Math.pow(getData(0), 2) + Math.pow(getData(1), 2) + Math.pow(getData(2), 2) + Math.pow(getData(3), 2));
    }

    @Override
    public Vector4 normalize() {
        final double length = length();
        if (length == 0) {
            throw new IllegalArgumentException("Нельзя нормализовать вектор с нулевой длиной");
        }
        final double newX = getData(0) / length;
        final double newY = getData(1) / length;
        final double newZ = getData(2) / length;
        final double newW = getData(3) / length;

        final double[] newData = {newX, newY, newZ, newW};
        return new Vector4(newData);
    }

    @Override
    public double scalarProduct(Vector other) {
        if (!(other instanceof Vector4)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 4)");
        }

        return getData(0) * other.getData(0) + getData(1) * other.getData(1) + getData(2) * other.getData(2) + getData(3) * other.getData(3);
    }


}
