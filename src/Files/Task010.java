// Task010: Reverse a string.

package Files;

import java.util.Scanner;

public class Task010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string that needs to reversed: ");
        String string = scanner.next();
        System.out.println("\n>\n");
        String revString = "";
        for (int i = string.length()-1; i >= 0; i--) {
            revString += string.charAt(i);
        }
        System.out.println(string+" | "+revString);
    }
}
