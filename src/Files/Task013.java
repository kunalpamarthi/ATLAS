// Task012: Create a List with 5 friends names.

package Files;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task013 {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter your friends name: ");
            name = scanner.next();
            friends.add(name);
        }

        System.out.println("\nFriends: "+friends);
        scanner.close();
    }
}
