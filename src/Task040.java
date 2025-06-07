//Task 040 Working of Abstraction in Java
abstract class Gadgets {
    abstract void turnOn();
    abstract void turnOff();
}

class TVRemote extends Gadgets {
    @Override
    void turnOn() {
        System.out.println("TV is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}
class ACRemote extends Gadgets {
    @Override
    void turnOn() {
        System.out.println("AC is turned ON.");
    }

    @Override
    void turnOff() {
        System.out.println("AC is turned OFF.");
    }
}

class FanRemote extends Gadgets{

    @Override
    void turnOn() {
        System.out.println("Fan is turned on.");
    }

    @Override
    void turnOff() {
        System.out.println("Fan is turned off.");
    }
}

class CoolerRemote extends Gadgets{

    @Override
    void turnOn() {
        System.out.println("Cooler is turned on.");
    }

    @Override
    void turnOff() {
        System.out.println("Cooler is turned off.");
    }
}

public class Task040 {
    public static void main(String[] args) {
        Gadgets acRemote = new ACRemote();
        Gadgets tvRemote = new TVRemote();
        tvRemote.turnOn();
        acRemote.turnOff();
        Gadgets fanRemote = new FanRemote();
        Gadgets coolerRemote = new CoolerRemote();
        fanRemote.turnOn();
        coolerRemote.turnOn();
    }
}
