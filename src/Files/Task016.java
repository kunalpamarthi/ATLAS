// Task016: Create an array list and filter the
// values which are odd numbers and display

package Files;

import java.util.ArrayList;
import java.util.List;

public class Task016 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i+1);
        }

        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        System.out.println("Original Numbers: " + numbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
