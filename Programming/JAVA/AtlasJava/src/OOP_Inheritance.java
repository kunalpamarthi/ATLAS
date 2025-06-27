class Vehicle{
    String brand;
    int year;
    Vehicle(String brand, int year){
        this.brand = brand;
        this.year = year;
    }
    void start(){
        System.out.println("Starting the vehicle........");
    }
}

class Car extends Vehicle{
    int doors;
    Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }

    void honk(){
        System.out.println("vroom vroom vroom");
    }
}

public class OOP_Inheritance {
    public static void main(String[] args) {
        Car car = new Car("Bentley", 1997, 2);
        car.start();
        car.honk();

    }
}
