package com.company.OOP.Composition;

public class Bed {

    private String size;
    private String color;
    private int pillows;
    private String sheetColor;

    public Bed(String size, String color, int pillows, String sheetColor) {
        this.size = size;
        this.color = color;
        this.pillows = pillows;
        this.sheetColor = sheetColor;
    }

    public void make() {
        System.out.println("Bed is made");
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
