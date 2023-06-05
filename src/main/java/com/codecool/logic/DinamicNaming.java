package com.codecool.logic;

public class DinamicNaming {
    private final String fileName;
    private int filenamenumber = 0;
    String generatedName;
    public DinamicNaming(String fileName) {
        this.fileName = fileName;
    }

    public String generateName(){
        filenamenumber++;
        generatedName = fileName + filenamenumber;
        return generatedName;
    }
}
