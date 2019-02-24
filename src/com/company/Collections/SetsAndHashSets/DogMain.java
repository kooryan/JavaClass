package com.company.Collections.SetsAndHashSets;

public class DogMain {

    public static void main(String[] args) {
        Coton rover = new Coton("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)); // Coton is an instance of Dog
        System.out.println(rover.equals(rover2)); // but a Dog is NOT an instance of Coton
        // This is demonstrating the SYMMETRIC rule that the equals method must obey
        // and must be equal on both sides

        // Both cases will be equal once we don't override it in the Coton class

    }
}
