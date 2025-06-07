// Type of parameters

import java.util.Scanner;

public class Task035 {
    static void add(double a, double b){
        System.out.println("Sum of given numbers: "+ (a+b));
    }
    static void add(char a, char b){
        System.out.println("Sum of given numbers: "+ (a+b));
    }
    static void add(int a, int b){
        System.out.println("Sum of given numbers: "+ (a+b));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        char ca = 'a', cb='b';
        add(a, b);
        add((double) a, b);
        add(ca, cb);

        scanner.close();
    }
}
