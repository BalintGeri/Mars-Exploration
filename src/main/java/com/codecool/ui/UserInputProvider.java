package com.codecool.ui;

import java.util.Scanner;

public class UserInputProvider {
    private int mapSize;
    private int numberOfMountains;
    private int numberOfPits;
    private String fileName;
    private final Scanner scanner = new Scanner(System.in);

    public int getNumberOfMountains() {
        return numberOfMountains;
    }

    public int getNumberOfPits() {
        return numberOfPits;
    }

    public String getFileName() {
        return fileName;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void promptMapSize() {
        mapSize = scanner.nextInt();
    }

    public void promptNumberOfMountains() {
        numberOfMountains = scanner.nextInt();
    }

    public void promptNumberOfPits() {
        numberOfPits = scanner.nextInt();
    }

    public void promptFileName() {
        fileName = scanner.next();
    }

    public void getUserInput() {
        System.out.println("Please, provide a single integer for the desired map size (will be the vertical and horizontal size of the 2D map, 20-200)!");
        promptMapSize();
        System.out.println("Please, provide a single integer for the desired number of mountains (1-10)!");
        promptNumberOfMountains();
        System.out.println("Please, provide a single integer for the desired number of pits (1-10)!");
        promptNumberOfPits();
        System.out.println("Please, provide the desired name of the file for the simulation to save (input the name only, can include any type of characters, .txt is not required)");
        promptFileName();
    }
}
