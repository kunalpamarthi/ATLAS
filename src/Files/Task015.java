// Task015: Create a list of 5 integers and display the squares of each.

package Files;

import java.util.Arrays;
import java.util.List;


public class Task015 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
                .map(num -> num * num)
                .toList();

        System.out.println("Original Numbers: " + numbers);
        System.out.println("Squares: " + squares);
    }
}
