/*Task004
Write a Program to Swap Two Numbers
Input: a=2  b=5
Output: a=5  b=2
*/

import java.util.Scanner;

public class Task004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers to swap: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println("num1: "+num1+"\t num2: "+num2);
        int temp;
        temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1: "+num1+"\t num2: "+num2);
    }
}
