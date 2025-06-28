// Task014: Split-iterator.

package LinkedLists;

import java.util.LinkedList;
import java.util.Spliterator;

public class Task014 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("shiro");
        list.add("goboy");
        list.add("etherious");
        Spliterator<String> spliterator = list.spliterator();
        System.out.println("Splitting the list: ");
        spliterator.forEachRemaining(System.out::println);
    }
}
