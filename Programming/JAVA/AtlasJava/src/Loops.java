import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j=0, k=0, sum=0, n=scanner.nextInt(), fact=1;

        for (i=0; i<=n; i++){
            sum += i;
        }
        System.out.println("Sum: " + sum);

        while (n > 0){
            fact *= n;
            n--;
        }
        System.out.println("Factorial: " + fact);

        do {
            System.out.println("Enter your pin: ");
            int pin = scanner.nextInt();
            int correctPin = 1234;
            if (pin == correctPin){
                System.out.println("Correct PIN");
                break;
            }
            else {
                k++;
            }
        }while (k<3);

        scanner.close();
    }
}
