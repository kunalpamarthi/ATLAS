//Task 010: WAP to check greater of 3 numbers

import java.util.Scanner;

public class Task010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        if (num1>num2 && num1>num3){
            System.out.println(num1+
                    " is greater among all the numbers provided.");
        } else if (num2>num1 && num2>num3) {
            System.out.println(num2+
                    " is greater among all the numbers provided.");
        }
        else {
            System.out.println(num3 +
                    " is greater among all the numbers provided.");
        }
        scanner.close();
    }
}
