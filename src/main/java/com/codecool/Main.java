package com.codecool;

import com.codecool.data.MapConfig;
import com.codecool.logic.MapGenerator;
import com.codecool.ui.GetUserInput;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GetUserInput input = new GetUserInput();
        input.promptInput();
        MapConfig config = new MapConfig(input);
        MapGenerator whatMarsLooksLike = new MapGenerator();
        try {
            whatMarsLooksLike.generateFullTerrainViewOfMars(config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}