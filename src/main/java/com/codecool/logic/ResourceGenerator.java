package com.codecool.logic;

import com.codecool.data.Coordinate;
import com.codecool.data.ElementType;
import com.codecool.data.Map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class ResourceGenerator implements RNGProvider {
    private final Map map;
    private final ElementType type;
    private final LinkedHashMap<Coordinate, ElementType> mapWithLandscape;
    private final ElementType parentTerrainElement;

    public ResourceGenerator(Map map, LinkedHashMap<Coordinate, ElementType> mapWithLandscape, ElementType type, ElementType parentTerrainElement) {
        this.map = map;
        this.mapWithLandscape = mapWithLandscape;
        this.type = type;
        this.parentTerrainElement = parentTerrainElement;
    }

    public Coordinate getEmptyCoordinate(Coordinate base) {
        for (int x = base.x() - 1; x < base.x() + 1; x++) {
            for (int y = base.y() - 1; y < base.y() + 1; y++) {
                Coordinate temp = new Coordinate(x, y);
                if (map.getMapCoordinate(temp) == ElementType.EMPTY) {
                    return temp;
                }
            }
        }
        return null;
    }

    @Override
    public int sizeRNG() {
        Random random = new Random();
        return random.nextInt(2, 9);
    }

    private List<Coordinate> getTerrainElements() {
        List<Coordinate> coordinates = mapWithLandscape.keySet().stream().toList();
        List<ElementType> types = mapWithLandscape.values().stream().toList();
        List<Coordinate> shapeList = new ArrayList<>();
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).equals(parentTerrainElement)) {
                shapeList.add(coordinates.get(i));
            }
        }
        return shapeList;
    }

    private Coordinate baseElement() {
        List<Coordinate> pits = getTerrainElements();
        Random rand = new Random();
        return pits.get(rand.nextInt(pits.size()));
    }

    private void setResource(Coordinate emptyCoordinate) {
        map.setCoordinateElement(emptyCoordinate, this.type);
    }

    public void initResources() {
        int shapeSize = sizeRNG();
        int counter = 0;
        while (counter < shapeSize) {
            counter++;
            Coordinate base = baseElement();
            Coordinate valid = getEmptyCoordinate(base);
            setResource(valid);
        }
    }
}
