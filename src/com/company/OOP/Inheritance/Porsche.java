package com.company.OOP.Inheritance;

public class Porsche extends Car {

    private int roadServiceMonths;

    public Porsche(int roadServiceMonths) {
        super("Porsche", "4WD", 4, 4, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate(int rate) {

        int newVelocity = getCurrentVelocity() + rate;

        if (newVelocity == 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <= 20) {
            changeGear(2);
        }


        if (newVelocity > 0 ) {
            changeVelocity(getCurrentDirection(), newVelocity);
        }
    }
}

