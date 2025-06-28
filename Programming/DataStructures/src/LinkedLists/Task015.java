// Task015: tryAdvance()

package LinkedLists;

import java.util.LinkedList;
import java.util.Spliterator;

public class Task015 {
    public static void main(String[] args) {
        java.util.LinkedList<String> list = new LinkedList<>();
        list.add("shiro");
        list.add("goboy");
        list.add("etherious");
        Spliterator<String> spliterator = list.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        System.out.println("Splitting the list: ");
        while (spliterator.tryAdvance(System.out::println));

        System.out.println("Splitting the list: ");
        while (spliterator1.tryAdvance(System.out::println));
    }
}
