package com.codecool.data;

import java.util.Objects;

public record Coordinate(int x, int y) {
    public Coordinate {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Invalid coordinate values: x=" + x + ", y=" + y + ". Coordinates can only consist of positive integers!");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}