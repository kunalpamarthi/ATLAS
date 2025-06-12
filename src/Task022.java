// Task 022: Create an array of integers,
// read values into the array and print.

import java.util.Scanner;

public class Task022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++) {
            intArr[i] = n-i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(intArr[i]+" ");
        }
        scanner.close();
    }
}
