package com.codecool.data;

import com.codecool.ui.UserInputProvider;

public class MapConfig {
    private final int mapSize;
    private final int numberOfMountains;
    private final int numberOfPits;
    private final String fileName;

    public MapConfig(UserInputProvider input) {
        this.mapSize = input.getMapSize();
        this.numberOfMountains = input.getNumberOfMountains();
        this.numberOfPits = input.getNumberOfPits();
        this.fileName = input.getFileName();
    }

    public int getMapSize() {
        return mapSize;
    }

    public String getFileName() {
        return fileName;
    }

    public int getNumberOfMountains() {
        return numberOfMountains;
    }

    public int getNumberOfPits() {
        return numberOfPits;
    }
}
