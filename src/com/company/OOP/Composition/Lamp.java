package company.OOP.Composition;

public class Lamp {

    private String color;

    public Lamp(String color) {
        this.color = color;
    }

    public void turnOn() {
        System.out.println("Lamp is turned on");
    }

    public String getColor() {
        return color;
    }
}


