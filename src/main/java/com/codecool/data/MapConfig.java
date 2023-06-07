package com.codecool.data;

import com.codecool.ui.UserInputProvider;

public class MapConfig {
    private final int size;
    private final int noOfMtns;
    private final int noOfPits;
    private final String fileName;

    public MapConfig(UserInputProvider input) {
        this.size = input.getMapSize();
        this.noOfMtns = input.getNumberOfMountains();
        this.noOfPits = input.getNumberOfPits();
        this.fileName = input.getFileName();
    }

    public int getSize() {
        return size;
    }

    public String getFileName() {
        return fileName;
    }

    public int getNoOfMtns() {
        return noOfMtns;
    }

    public int getNoOfPits() {
        return noOfPits;
    }
}
