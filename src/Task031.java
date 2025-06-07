class Calculation {
    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers: "+z);
    }

    public void Subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers: "+z);
    }
}

public class Task031 extends Calculation {
    public static void main(String[] args) {
        Task031 calc = new Task031();
        calc.addition(43, 90);
        calc.Subtraction(90, 12);
        calc.multiplication(24, 3);
    }

    void multiplication(int x, int y){
        int z = x*y;
        System.out.println("The product given numbers is: "+z);
    }
}
