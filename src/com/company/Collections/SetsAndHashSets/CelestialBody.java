package company.Collections.SetsAndHashSets;

import java.util.HashSet;
import java.util.Set;

public abstract class CelestialBody { // remove final to allow subclassing
    private final Key key;
    private final double orbitalPeriod;
    private final Set<CelestialBody> satellites;


    public enum BodyTypes { // Enums are TYPES
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public CelestialBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType); // even though it's a private constructor it's an inner class so it gives us access
        this.orbitalPeriod = orbitalPeriod; //  to the class without having to do singletons
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(CelestialBody moon) {
        return this.satellites.add(moon); // also returns true if this was successful
    }

    public Set<CelestialBody> getSatellites() {
        return new HashSet<>(this.satellites); // creating new HashSet containing the contents of our satellite, for immutability purposes
    }

    @Override
    // makes sure the compiler is checking is checking to whether you have got the right signature for the method
    public final boolean equals(Object obj) { // do not overload by making the parameter "CelestialBody obj"
        if (this == obj) { // mark method as final in order to maintain symmetry
            return true;
        }

        if (obj instanceof CelestialBody) {
            CelestialBody theObject = (CelestialBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() { // same reason for equals as making this method final
        //  System.out.println("hashcode() called");
        return this.key.hashCode();
        // We are using the code that comes back from the String and adding 57 to it is
        // a non-zero number because the hashcode returned by the string - then we add 57
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static Key makeKey(String name, BodyTypes bodyType) { // creates a new "designation" for every obj method call to this
        return new Key(name, bodyType);
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyType = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;

            if (this.name.equals(key.getName())) {
                return this.bodyType == key.bodyType;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
