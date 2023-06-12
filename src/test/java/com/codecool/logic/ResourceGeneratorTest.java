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
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
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
    public void getEmptyCoordinateThenReturnEmpty() {
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
    public void getEmptyCoordinateThenReturnNull() {
        //given
        Coordinate coordinate = new Coordinate(2,2);
        when(map.getMapCoordinate(any())).thenReturn(ElementType.WATER);
        //when
        Coordinate emptyCoordinate = resourceGenerator.getEmptyCoordinate(coordinate);
        //then
        assertNull(emptyCoordinate);
    }
    //test case in progress
    /*@MockitoSettings(strictness = Strictness.LENIENT)
    @Test
    public void getEmptyCoordinateWhenCoordinate00ThenEmpty() {
        //given
        Coordinate coordinate = new Coordinate(0,0);
        when(map.getMapCoordinate(eq(coordinate))).thenReturn(null);
        //when
        Coordinate emptyCoordinate = resourceGenerator.getEmptyCoordinate(coordinate);
        //then
        assertEquals(0, emptyCoordinate.x());
        assertEquals(0, emptyCoordinate.y());
    }*/

    @Test
    public void sizeRNGReturnsValueInRange() {
        int result = resourceGenerator.sizeRNG();
        int min = 2;
        int max = 9;
        assertTrue(min <= result && result <= max);
    }
}