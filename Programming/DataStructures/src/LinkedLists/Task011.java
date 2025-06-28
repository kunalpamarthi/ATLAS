// Task011: convert the linked list to an array and display

package LinkedLists;

import java.util.Arrays;
import java.util.LinkedList;

public class Task011 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.print("List: ");
        for (String s : list) {
            System.out.print(s + "->");
        }
        System.out.println("Null");
        Object[] a = list.toArray(new String[0]);
        System.out.println("Array: "+ Arrays.toString(Arrays.stream(a).toArray()));
    }
}
