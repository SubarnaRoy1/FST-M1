package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car(){
        this.tyres=4;
        this.doors=4;
    }

    public void displayCharacteristics(){
        System.out.println("Color of car is " + color);
        System.out.println("Transmission of car is " + transmission);
        System.out.println("Make of car is " + make);
        System.out.println("Tyres of car is " + tyres);
        System.out.println("Doors of car is " +doors);
    }

    public void accelerate(){
        System.out.println("Car is moving forward");
    }

    public void brake(){
        System.out.println("Car has stopped");
    }
}
