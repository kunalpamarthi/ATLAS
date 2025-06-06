//Task003: Write a Program in Java to Add two Numbers.
import java.util.Scanner;

public class Task003 {
    static int add(int a, int b){
        return a+b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = add(a, b);
        System.out.println("Sum of given two number is "+ sum);
    }

}
