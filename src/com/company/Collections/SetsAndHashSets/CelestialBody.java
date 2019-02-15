package com.company.Collections.SetsAndHashSets;

import java.util.HashSet;
import java.util.Set;

public final class CelestialBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<CelestialBody> satellites;

    public CelestialBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(CelestialBody moon) {
        return this.satellites.add(moon); // also returns true if this was successful
    }

    public Set<CelestialBody> getSatellites() {
        return new HashSet<>(this.satellites); // creating new HashSet containing the contents of our satellite, for immutability purposes
    }

    @Override
    public boolean equals(Object obj) { // do not overload by making the parameter "CelestialBody obj"
        if (this == obj) {
            return true;
        }

        System.out.println("obj.getClass is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((CelestialBody) obj).getName();
        return this.name.equals(objName);
    }


}
