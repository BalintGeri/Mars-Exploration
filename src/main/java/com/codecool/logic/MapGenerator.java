package com.codecool.logic;

import com.codecool.data.ElementType;
import com.codecool.data.Map;
import com.codecool.data.MapConfig;

import java.io.IOException;

public class MapGenerator {
    public void generateFullTerrainViewOfMars(MapConfig mapConfig) throws IOException {
        FileNameProvider name = new FileNameProvider(mapConfig.getFileName());
        String generateName = name.generateName();
        Map map = new Map(mapConfig);
        FileWriter toFile = new FileWriter(mapConfig);
        LandscapeGenerator generateMountains = new LandscapeGenerator(mapConfig, map, ElementType.MOUNTAIN);
        LandscapeGenerator generatePit = new LandscapeGenerator(mapConfig, map, ElementType.PIT);
        ResourceGenerator water = new ResourceGenerator(map, map.getMap(), ElementType.WATER, ElementType.PIT);
        ResourceGenerator mineral = new ResourceGenerator(map, map.getMap(), ElementType.MINERAL, ElementType.MOUNTAIN);

        for (int i = 0; i < mapConfig.getNumberOfMountains(); i++) {
            generateMountains.placeMapObjectsBasedOnConfig();
        }
        for (int i = 0; i < mapConfig.getNumberOfPits(); i++) {
            generatePit.placeMapObjectsBasedOnConfig();
        }

        water.initResources();
        mineral.initResources();
        toFile.saveMapToFile(map.getMap(), generateName);
        toFile.printMapToConsole(map.getMap());
    }
}
