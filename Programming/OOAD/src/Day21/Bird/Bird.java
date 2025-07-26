// Task001 and Task002: implementation of Liskov

package Day21.Bird;

public class Bird {
    public static void main(String[] args) {
        FlyingBirds eagle = new Eagle();
        NonFlyingBirds emu = new Ostrich();
        eagle.fly();
        emu.speciality();
    }
}
