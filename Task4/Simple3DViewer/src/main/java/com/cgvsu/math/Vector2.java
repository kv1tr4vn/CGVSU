package com.cgvsu.math;

import java.util.Arrays;

public class Vector2 implements Vector {

    private final double[] data;


    public Vector2(double[] data) {
        if (data.length != 2) {
            throw new IllegalArgumentException("Данный вектор не правильной размерности(ожидается размер 2)");
        }
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "data=" + Arrays.toString(data) +
                '}';
    }


    @Override
    public double getData(int i) {
        return data[i];
    }


    @Override
    public Vector2 sum(Vector other) {
        if (!(other instanceof Vector2)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 2)");
        }
        final double newX = getData(0) + other.getData(0);
        final double newY = getData(1) + other.getData(1);

        final double[] newData = {newX, newY};
        return new Vector2(newData);
    }


    @Override
    public Vector2 subtract(Vector other) {
        if (!(other instanceof Vector2)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 2)");
        }
        final double newX = getData(0) - other.getData(0);
        final double newY = getData(1) - other.getData(1);

        final double[] newData = {newX, newY};
        return new Vector2(newData);
    }

    @Override
    public Vector2 multiplyOnScalar(double scalar) {

        final double newX = getData(0) * scalar;
        final double newY = getData(1) * scalar;

        final double[] newData = {newX, newY};
        return new Vector2(newData);
    }

    @Override
    public Vector2 divisionOnScalar(double scalar) {
        final double newX = getData(0) / scalar;
        final double newY = getData(1) / scalar;

        final double[] newData = {newX, newY};
        return new Vector2(newData);
    }


    @Override
    public double length() {

        return Math.sqrt(Math.pow(getData(0), 2) + Math.pow(getData(1), 2));
    }

    @Override
    public Vector2 normalize() {
        double length = length();
        if (length == 0) {
            throw new IllegalArgumentException("Нельзя нормализовать вектор с нулевой длиной");
        }
        final double newX = getData(0) / length;
        final double newY = getData(1) / length;

        final double[] newData = {newX, newY};
        return new Vector2(newData);
    }

    @Override
    public double scalarProduct(Vector other) {
        if (!(other instanceof Vector2)) {
            throw new IllegalArgumentException("Переданный вектор не подходит по размеру(ожидается размер 2)");
        }

        return getData(0) * other.getData(0) + getData(1) * other.getData(1);
    }


}
