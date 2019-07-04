package company.OOP.Inheritance;

public class Car extends vehicle {

    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("CarMain.setCurrentGear: Changed to " + this.currentGear + " gear.");
    }

    public void changeVelocity (int direction, int speed){
        move(speed, direction);
        System.out.println("Moving at Velocity " + speed + " mph, direction " + direction + " degrees.");
    }

}
