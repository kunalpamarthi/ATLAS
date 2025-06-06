// Task 012: WAP to check login id and password validation.

import java.util.Scanner;

public class Task012 {
    static Scanner scanner = new Scanner(System.in);
    static int loginCounter = 0;
    public static void main(String[] args) {
        String id = "shirokun";
        String password = "12345678";
        System.out.println("Entering while loop...\n");
        whileCheck(id, password, loginCounter);
        System.out.println("\tExited while loop.\n");
        System.out.println("Entering do-while loop...\n");
        do_whileCheck(id, password, loginCounter);
        System.out.println("\tExited do-while loop.\n");
    }

    private static void do_whileCheck(
            String id, String password, int loginCounter) {
        String inputId, inputPassword;
        do {
            System.out.println("You have logged in for "+
                    loginCounter++ +"times.");
            System.out.print("Enter your login id: ");
            inputId = scanner.next();
            System.out.print("Enter your password: ");
            inputPassword = scanner.next();
        }while (inputId.equals(id) && inputPassword.equals(password));
    }

    private static void whileCheck(
            String id, String password, int loginCounter) {
        String inputId = id, inputPassword = password;
        while ((inputPassword.equals(password)) && (inputId.equals(id))){
            System.out.println("You have logged in for "+
                    loginCounter++ +"times.");
            System.out.print("Enter your login id: ");
            inputId = scanner.next();
            System.out.print("Enter your password: ");
            inputPassword = scanner.next();
        }
    }
}
