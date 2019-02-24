package com.company.Collections.SetsAndHashSets;

import com.company.Collections.SetsAndHashSets.SetsChallenge.Moon;
import com.company.Collections.SetsAndHashSets.SetsChallenge.Planet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sets {
    private static Map<CelestialBody.Key, CelestialBody> solarSystem = new HashMap<>();
    private static Set<CelestialBody> planets = new HashSet<>();

    public static void main(String[] args) {
        CelestialBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        CelestialBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callist`o", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        printPlanets();

        printPlanetMoon("Mars", CelestialBody.BodyTypes.PLANET);

        Set<CelestialBody> moons = new HashSet<>(); // creating a union Set
        for (CelestialBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All moons: ");
        for (CelestialBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }

        CelestialBody pluto = new /*Dwarf*/Planet("Pluto", 842); // will create a duplicate Neptune
        planets.add(pluto);

        printPlanets();
        // the reason why Neptune (Pluto) prints twice is
        // the two java objects do not compare equal

        // once we add the hashcode method, the duplicate Neptune will not be added.
        // now fits the behavior of a set, no duplicate objects

        CelestialBody earth1 = new Planet("Earth", 365);
        CelestialBody earth2 = new Planet("Earth", 365);

        System.out.println(earth1.equals(earth2)); // should be symmetric
        System.out.println(earth2.equals(earth1));

        System.out.println(earth1.equals(pluto));
        System.out.println(pluto.equals(earth1));

        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(CelestialBody.makeKey("Pluto", CelestialBody.BodyTypes.PLANET)));

        System.out.println(solarSystem.get(CelestialBody.makeKey("Pluto", CelestialBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("The solar system contains: ");
        for (CelestialBody celestialBody : solarSystem.values()) {
            System.out.println(celestialBody);
        }
    }

    public static void printPlanets() {
        System.out.println("Planets: ");
        for (CelestialBody planet : planets) {
            System.out.println(planet);
        }
    }

    public static void printPlanetMoon(String planet, CelestialBody.BodyTypes bodyTypes) {
        CelestialBody body = solarSystem.get(CelestialBody.makeKey(planet, bodyTypes));
        System.out.println("Moons of " + body.getKey());
        for (CelestialBody planetMoons : body.getSatellites()) {
            System.out.println("\t" + planetMoons.getKey());
        }
    }
}
