package com.company;

import com.company.OOP.Inheritance.Porsche;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Object{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /** Inheritance */

//        Porsche porsche = new Porsche(36);
//        porsche.accelerate(20);

        /** Composition */

//        Bed bed = new Bed("King", "Black", 1, "Green and Blue");
//        Lamp lamp = new Lamp("Steel");
//        Computer computer = new Computer("Asus");
//        Bedroom bedroom = new Bedroom(bed, computer, lamp);
//
//        bedroom.makeBed();
//        System.out.println(bedroom.getLamp().getColor());

        /** Encapsulation */

//        Printer printer = new Printer(100, false);
//        printer.printPaper(100);

        /** Polymorphism */


        /** Java Generics */

        //        ArrayList<Integer> items = new ArrayList<>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add(4);
//        items.add(5);
//
//        printDoubled(items);
//
//
//        Football_Player joe = new Football_Player("Joe");
//        Baseball_Player pat = new Baseball_Player("Pat");
//        Soccer_Player beckham = new Soccer_Player("Beckham");
//
//
//        Team<Soccer_Player> ManU = new Team<>("Manchester United");
//        ManU.addPlayer(beckham);
//        System.out.println(ManU.numPlayers());
//
//        Team<Baseball_Player> baseball_playerTeam = new Team<>("Chicago Cubs");
//        baseball_playerTeam.addPlayer(pat);
//
//
//        Soccer_Player tevez = new Soccer_Player("Tevez");
//        Team<Soccer_Player> ManCity = new Team<>("Manchester City");
//        ManCity.addPlayer(tevez);
//
//
//        ManCity.matchResult(ManU, 1, 0);
//        ManU.matchResult(baseball_playerTeam, 2, 1);
//
//        System.out.println("Rankings");
//        System.out.println(ManCity.getName() + " : " + ManCity.ranking());
//        System.out.println(ManU.getName() + " : " + ManU.ranking());
//
//        System.out.println(ManCity.compareTo(ManCity));
//        System.out.println(ManU.compareTo(ManCity));
//        System.out.println(ManCity.compareTo(ManU));
        // ArrayList<Team> team = new ArrayList<>();
        // Collections.sort(team);

        //** Arrays and Java built in lists


    }

    /** Java Generics */

    private static void printDoubled(ArrayList<Integer> n) {
        for(int i : n) {
             System.out.println(i * 2);
        }
    }
}
