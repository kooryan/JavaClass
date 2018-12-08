package com.company.OOP.Composition;

public class Bedroom {

    private Bed bed;
    private Computer computer;
    private Lamp lamp;

    public Bedroom(Bed bed, Computer computer, Lamp lamp) {
        this.bed = bed;
        this.computer = computer;
        this.lamp = lamp;
    }

    public Lamp getLamp() {
        return this.lamp;
    }

    public void makeBed() {
        bed.make();
    }

    public void lampOn() {
        lamp.turnOn();
    }
}

