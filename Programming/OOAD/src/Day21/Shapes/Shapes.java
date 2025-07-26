// Task003 and Task004: ISP implementation

package Day21.Shapes;

public class Shapes {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        Sphere sphere = new Sphere(7);
        System.out.println("Area of the given circle: "+circle.calcArea());
        System.out.println("Perimeter of the given circle: "+circle.calcPeri());
        System.out.println("Volume of the given sphere: "+sphere.calcVolume());
        System.out.println("Area of the given sphere: "+sphere.calcArea());
        System.out.println("Perimeter of the given sphere: "+sphere.calcPeri());
        System.out.println();

    }
}
