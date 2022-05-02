package activities;

public class Activity1 {
    public static void main(String[] args) {
        Car Xylo=new Car();
        Xylo.make=2014;
        Xylo.color="Black";
        Xylo.transmission="Manual";

        Xylo.displayCharacteristics();
        Xylo.accelerate();
        Xylo.brake();
    }
}
