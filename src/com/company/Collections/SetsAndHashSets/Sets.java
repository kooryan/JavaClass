package com.company.Collections.SetsAndHashSets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sets {
    private static Map<String, CelestialBody> solarSystem = new HashMap<>();
    private static Set<CelestialBody> planets = new HashSet<>();

    public static void main(String[] args) {
        CelestialBody temp = new CelestialBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new CelestialBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new CelestialBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        CelestialBody tempMoon = new CelestialBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new CelestialBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new CelestialBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new CelestialBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new CelestialBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new CelestialBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new CelestialBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new CelestialBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new CelestialBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new CelestialBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new CelestialBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new CelestialBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        printPlanets();

        printPlanetMoon("Mars");

        Set<CelestialBody> moons = new HashSet<>(); // creating a union Set
        for (CelestialBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons: ");
        for (CelestialBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        CelestialBody neptune = new CelestialBody("Neptune", 842); // will create a duplicate Neptune
        planets.add(neptune);

        printPlanets();
        // the reason why Neptune prints twice is
        // the two java objects do not compare equal

        Object o = new Object();
        o.equals(o); // different from the String .equals
        "pluto".equals("");

    }

    public static void printPlanets() {
        System.out.println("Planets: ");
        for (CelestialBody planet : planets) {
            System.out.println("\t" + planet.getName() + ": " +planet.getOrbitalPeriod());
        }
    }

    public static void printPlanetMoon(String planet) {
        CelestialBody body = solarSystem.get(planet);
        System.out.println("Moons of " + body.getName());
        for (CelestialBody planetMoons : body.getSatellites()) {
            System.out.println("\t" + planetMoons.getName());
        }
    }
}
