package com.codecool.logic;

public class FileNameProvider {
    private final String fileName;
    private int fileNameNumber = 0;
    private String generatedName;

    public FileNameProvider(String fileName) {
        this.fileName = fileName;
    }

    public String generateName() {
        fileNameNumber++;
        generatedName = fileName + fileNameNumber;
        return generatedName;
    }
}
