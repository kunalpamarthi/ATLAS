// Task017: Remove duplicates.

package Files;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task017 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            numbers.add(i+1);
            numbers.add(i+1);
        }

        // Remove duplicates using Stream API
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Original List: " + numbers);
        System.out.println("List without duplicates: " + uniqueNumbers);
    }
}
