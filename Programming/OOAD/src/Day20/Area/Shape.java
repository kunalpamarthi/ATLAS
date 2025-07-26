package Day20.Area;

public interface Shape {
    double area();
}

class Circle implements Shape{
    int radius;
    Circle(int radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}

class Square implements Shape{
    int side;
    Square(int side){
        this.side = side;
    }
    @Override
    public double area() {
        return side*side;
    }
}