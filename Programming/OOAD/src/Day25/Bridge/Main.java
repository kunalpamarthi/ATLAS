package Day25.Bridge;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bridge Method Design Pattern - Structural DP!");
        ExcaliDrawAPI obj1 = new DrawingFrame();
        ExcaliDrawAPI obj2 = new DrawingPicture();
        
        Shape square = new Square(5);
        
        square.draw();
    }
}