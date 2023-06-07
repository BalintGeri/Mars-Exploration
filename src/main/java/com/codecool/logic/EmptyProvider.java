package com.codecool.logic;

import com.codecool.data.Coordinate;

import java.util.List;

public interface EmptyProvider {
    List<Coordinate> getEmptyCoordinates(Coordinate base);
}
