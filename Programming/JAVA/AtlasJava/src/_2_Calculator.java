import java.util.Scanner;

public class _2_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome user!! available math operations are:\n\t (+) Addition\n\t (-) Subtraction\n\t (*) Multiplication\n\t (/) Division\n");
        System.out.println("How to use: \n 1. Enter the first number.\n 2. Enter the operation symbol.\n 3. Enter the second number.");
        boolean key = true;

        while (key){
            System.out.println("_______________________________________________________________________");
            double num1 = scanner.nextDouble();
            char op = scanner.next().charAt(0);
            double num2 = scanner.nextDouble();

            switch (op) {
                case '+':
                    System.out.println(num1 + num2);
                    break;
                case '-':
                    System.out.println(num1 - num2);
                    break;
                case '*':
                    System.out.println(num1 * num2);
                    break;
                case '/':
                    System.out.println((num2 == 0) ? "!! Division by 0" : (num1 / num2));
                    break;
                case 'q':

                    break;
                default:
                    System.out.println("Unexpected value: " + op);
            }
            System.out.println("Press any key to continue. [Q] to quit.");
            char decision = scanner.next().toLowerCase().charAt(0);
            key = (decision != 'q');
        }
        System.out.println("\n\tThank you!!");
        scanner.close();
    }
}
