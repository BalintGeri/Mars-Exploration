package com.codecool.logic;

import com.codecool.data.MapConfig;
import com.codecool.ui.UserInputProvider;

import java.io.IOException;

public class Simulation {
    public void run() {
        UserInputProvider input = new UserInputProvider();
        input.getUserInput();
        MapConfig config = new MapConfig(input);
        MapGenerator mapGenerator = new MapGenerator();
        try {
            mapGenerator.generateFullTerrainViewOfMars(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
