package com.codecool.logic;

import com.codecool.data.Coordinate;
import com.codecool.data.ElementType;
import com.codecool.data.Map;
import com.codecool.data.MapConfig;
import com.codecool.ui.UserInputProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResourceGeneratorTest {
    ResourceGenerator resourceGenerator;
    MapConfig mapConfig;
    @Mock
    UserInputProvider userInputProvider;
    @Mock
    Map map;
    @BeforeEach
    public void setup(){
        mapConfig = new MapConfig(userInputProvider);
        resourceGenerator = new ResourceGenerator(map, new LinkedHashMap<>(), ElementType.EMPTY, ElementType.EMPTY);

    }

    @Test
    public void getEmptyCoordinate() {
       //given
        Coordinate coordinate = new Coordinate(2,2);
        when(map.getMapCoordinate(any())).thenReturn(ElementType.EMPTY);

        //when
        Coordinate emptyCoordinate = resourceGenerator.getEmptyCoordinate(coordinate);

        //then
        assertEquals(emptyCoordinate.x(), 1);
        assertEquals(emptyCoordinate.y(), 1);
    }

    @Test
    public void sizeRNG() {
        //to be implemented
    }
}