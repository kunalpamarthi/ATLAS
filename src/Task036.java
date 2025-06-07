// Sequence of parameters

public class Task036 {
    static void add(float a, int b){
        System.out.println("Sum of the given numbers "
                +a +" and "+b+ " is: "+(a+b));
    }
    static void add(int a, float b){
        System.out.println("Sum of the given numbers "
                +a +" and "+b+ " is: "+(a+b));
    }
    public static void main(String[] args) {
        int a=10;
        float b=56.89F;
        add(a, b);
        add(b, a);
    }
}
