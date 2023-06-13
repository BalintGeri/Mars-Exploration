package com.codecool.logic;

import com.codecool.data.Coordinate;
import com.codecool.data.Data;
import com.codecool.data.ElementType;
import com.codecool.data.MapConfig;

import java.io.IOException;
import java.util.LinkedHashMap;

public class FileWriter {
    private final MapConfig config;

    public FileWriter(MapConfig config) {
        this.config = config;
    }

    public void printMapToConsole(LinkedHashMap<Coordinate, ElementType> map) {
        for (int x = 0; x < this.config.getMapSize(); x++) {
            for (int y = 0; y < this.config.getMapSize(); y++) {
                System.out.print(map.get(new Coordinate(x, y)).getValue());
            }
            System.out.println();
        }
    }

    public void saveMapToFile(LinkedHashMap<Coordinate, ElementType> map, String fileName) throws IOException {
        java.io.FileWriter writer = new java.io.FileWriter(Data.LOG_PATH + fileName + ".txt");
        for (int i = 0; i < this.config.getMapSize(); i++) {
            for (int j = 0; j < this.config.getMapSize(); j++) {
                writer.write(map.get(new Coordinate(i, j)).getValue());
            }
            writer.write("\n");
        }
        writer.close();
    }
}
