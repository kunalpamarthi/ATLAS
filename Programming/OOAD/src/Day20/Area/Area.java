// Task005: OCP Implementation

package Day20.Area;

public class Area {
    public static void main(String[] args) {
        Shape circle = new Circle(7);
        Shape square = new Square(14);
        System.out.println("Area difference for the both shapes is: "+compareAreas(circle, square));
    }

    private static double compareAreas(Shape circle, Shape square) {
        return circle.area()-square.area();
    }
}
