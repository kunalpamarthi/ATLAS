package Day21.Shapes;

public interface CalcArea {
    double calcArea();
    double calcPeri();
}

interface CalcVolume{
    double calcVolume();
}

class Circle implements CalcArea{
    int radius;
    Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double calcPeri() {
        return 2*Math.PI*radius;
    }
}

class Sphere implements CalcVolume, CalcArea{
    double radius;
    Sphere(double radius){
        this.radius = radius;
    }
    @Override
    public double calcVolume() {
        return ((4.0/3)*Math.PI*radius*radius*radius);
    }

    @Override
    public double calcPeri() {
        return 2*Math.PI*radius;
    }

    @Override
    public double calcArea() {
        return (4.0)*Math.PI*radius*radius;
    }
}
