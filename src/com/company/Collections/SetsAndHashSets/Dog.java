package company.Collections.SetsAndHashSets;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) { // now we are saying it cannot be overridden by declaring final
        if(this == obj) { // checking if same object in memory using ==
            return true;
        }

        if (obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        } else
            return false;
    }
}
