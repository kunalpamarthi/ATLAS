// Task012: Create an ArrayList with 5 friends names.

package Files;

import java.util.ArrayList;
import java.util.Scanner;

public class Task012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> friends = new ArrayList<String>();
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
