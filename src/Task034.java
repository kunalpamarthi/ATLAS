// No. of parameters

public class Task034 {
    static void add(int a, int b){
        System.out.println("Sum of given numbers: "+ (a+b));
    }

    static void add(int a, int b, int c){
        System.out.println("Sum of given numbers: "+ (a+b+c));
    }

    public static void main(String[] args) {
        add(1, 2);
        add(1, 5, 6);
    }
}
