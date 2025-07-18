// Task003: Take number from the user
// and display the no of digit it has.

package Misc;

import java.util.Scanner;

public class Task003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String num = scanner.next();
        System.out.println(num+" has "+num.length()+" digits.");
        scanner.close();
    }
}
