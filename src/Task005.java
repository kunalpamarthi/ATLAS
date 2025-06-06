/*Task005
Create a code in which you have 4 methods add, subtract, multiply and divide
(return type int) with a main method to call all the other methods.
*/

import java.util.Scanner;

public class Task005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to perform various math operations: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int sum = sum(num1, num2);
        int diff = sub(num1, num2);
        int prod = prod(num1, num2);
        int div = div(num1, num2);
        System.out.println("Sum of the given numbers is: " + sum +
                "\nDifference of the given numbers is: " + diff +
                "\nProduct of the given numbers is: " + prod +
                "\nQuotient of the given numbers is: " + div);
    }

    private static int div(int num1, int num2) {
        return num2/num1;
    }

    private static int prod(int num1, int num2) {
        return num1*num2;
    }

    private static int sub(int num1, int num2) {
        return num2-num1;
    }

    private static int sum(int num1, int num2) {
        return num1+num2;
    }
}
