//Task007: Write a program to take input from the user
// and display it to the user

import java.util.Scanner;

public class Task007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your id: ");
        String id = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();
        int passwordLength = password.length();
        System.out.println("Your id is: "+id+
                "\nYour password is: "+ "*".repeat(passwordLength));
    }
}
