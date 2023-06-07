package com.codecool.logic;

import com.codecool.data.Coordinate;
import com.codecool.data.ElementType;
import com.codecool.data.Map;
import com.codecool.data.MapConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LandscapeGenerator implements EmptyProvider, RNGProvider {
    private final MapConfig mapconfig;
    private final Map map;
    private final ElementType type;
    private List<Coordinate> result;

    public LandscapeGenerator(MapConfig mapconfig, Map map, ElementType type) {
        this.mapconfig = mapconfig;
        this.map = map;
        this.type = type;
        this.result = new ArrayList<>();
    }

    @Override
    public List<Coordinate> getEmptyCoordinates(Coordinate base) {
        result = new ArrayList<>();
        for (int x = base.x() - 1; x < base.x() + 2; x++) {
            for (int y = base.y() - 1; y < base.y() + 2; y++) {
                Coordinate temp = new Coordinate(x, y);
                if (temp.x() < 0) {
                    temp = new Coordinate(0, temp.y());
                }
                if (temp.x() >= this.mapconfig.getSize()) {
                    temp = new Coordinate(mapconfig.getSize() - 1, temp.y());
                }
                if (temp.y() < 0) {
                    temp = new Coordinate(temp.x(), 0);
                }
                if (temp.y() >= this.mapconfig.getSize()) {
                    temp = new Coordinate(temp.x(), mapconfig.getSize() - 1);
                }
                if (map.getMapCoordinate(temp).equals(ElementType.EMPTY)) {
                    this.result.add(temp);
                }
            }
        }
        return result;
    }

    @Override
    public int sizeRNG() {
        Random random = new Random();
        return random.nextInt(5, 20);
    }

    private Coordinate baseRNG() {
        Random random = new Random();
        return new Coordinate(random.nextInt(1, mapconfig.getSize()), random.nextInt(1, mapconfig.getSize()));
    }

    private Coordinate createTerrain(List<Coordinate> emptyCoordinates) {
        Random random = new Random();
        int randomNumber = 0;
        try {
            randomNumber = random.nextInt(emptyCoordinates.size());
        } catch (IllegalArgumentException e) {
            System.out.println(emptyCoordinates);
            System.out.println(map);
            throw new RuntimeException("out of bounds");
        }
        Coordinate first = emptyCoordinates.get(randomNumber);
        map.setCoordinateElement(first, this.type);
        return first;
    }

    public void placeMapObjectsBasedOnConfig() {
        int mountainSize = sizeRNG();
        int counter = 0;
        Coordinate base = baseRNG();
        List<Coordinate> emptyCoordinates = new ArrayList<>();
        while (counter < mountainSize) {
            counter++;
            emptyCoordinates.addAll(getEmptyCoordinates(base));
            base = createTerrain(emptyCoordinates);
            emptyCoordinates.remove(base);
        }
    }
}
