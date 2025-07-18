// Task002: Take input from the user a 5 digit num
// and display digit by digit in the output.

package Misc;

import java.util.Scanner;

public class Task002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 5 digit number: ");
        String num = scanner.next();
        if (num.length() != 5) {
            System.out.println("Number should be of 5 digits.");
            return;
        }
        String[] places = {"Ten thousand's", "Thousand's", "Hundred's", "Ten's",  "One's"};
        for (int i = num.length()-1; i > -1 ; i--) {
            System.out.println(places[i]+ " digit is: " +num.charAt(i));
        }
        scanner.close();
    }
}
