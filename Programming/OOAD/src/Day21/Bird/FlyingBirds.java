package Day21.Bird;

abstract class FlyingBirds {
    abstract void fly();
}

abstract class NonFlyingBirds{
    abstract void speciality();
}

class Eagle extends FlyingBirds{
    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}

class Ostrich extends NonFlyingBirds{
    @Override
    void speciality() {
        System.out.println("Laying biggest eggs..");
    }
}