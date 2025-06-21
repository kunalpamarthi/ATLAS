// Task015: Create a list of 5 integers and display the squares of each.

package Files;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task015 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number "+ (i+1)+": ");
            num = scanner.nextInt();
            numbers.add(num);
        }

        numbers.stream().forEach(n -> System.out.println(
                "Number: " + n + ", Square: " + (n * n)));
        scanner.close();
    }
}
