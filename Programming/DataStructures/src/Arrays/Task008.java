// Task008: Reverse a string, input from user.

package Arrays;

import java.util.Scanner;

public class Task008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string:  ");
        String str = scanner.nextLine();
        char temp;
        char[] chrArr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(str.length()-i-1);
            chrArr[i] = temp;
        }
        String revStr = new String(chrArr);
        System.out.println("Reversed string: "+revStr);
        scanner.close();
    }
}
