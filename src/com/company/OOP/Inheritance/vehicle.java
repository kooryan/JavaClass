package company.OOP.Inheritance;

public class vehicle {

    private String name;
    private String size;


    private int currentVelocity;
    private int currentDirection;

    public vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentDirection = 0;
        this.currentVelocity = 0;
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees");
    }

    public void move (int velocity, int direction) {
        currentVelocity = velocity;
        currentDirection = direction;

        System.out.println("Moving at " + direction + " degrees" + " at " + velocity + " mph");
    }


    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void stop() {
        this.currentVelocity = 0;
    }
}
