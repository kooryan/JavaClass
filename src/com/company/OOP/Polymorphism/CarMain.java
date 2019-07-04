package company.OOP.Polymorphism;

class Car {
    private boolean engines;
    private int cylinders;
    private int wheels;
    private String name;

    public Car(int cylinders, String name) {
        this.engines = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.name = name;
    }

    public String startEngine() {
        return "Car engine started";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

class Porsche extends Car {
    public Porsche(int cylinders, String name) {
        super(cylinders, name);
    }

    public String startEngine() {
        return "Porsche engine started";
    }
}

class Tesla extends Car {
    public Tesla(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Tesla engine started";
    }
}

class Hyundai extends Car {
    public Hyundai(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Hyundai engine started";
    }
}


public class CarMain {
    public static void main(String[] args) {
        for (int i = 1; i <11; i++) {
            Car car = randomCar();
            System.out.println("Movie #" + i +": " + car.getName() + "\n" +
                "Engine: " + car.startEngine() + "\n");
        }
    }

    public static Car randomCar() {
        int randomNumber = (int) (Math.random() * 3) +1;
        System.out.println("Number generated was: " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Porsche(4, "Porsche");
            case 2:
                return new Tesla(4, "Tesla");
            case 3:
                return new Hyundai(4, "Hyundai");

        }

        return null;
    }
}

