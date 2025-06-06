// Task 006: Write a program to check if 'a' is greater or 'b'. Use ternary op

import java.util.Scanner;

public class Task006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to check which one " +
                "is greater: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println( (a>b) ?
                "a(" +a+ ")is greater than b." :
                "b(" +b+ ") is greater than a.");
    }
}
