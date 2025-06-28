// Task012: Clone a list

package LinkedLists;

import java.util.LinkedList;

public class Task012 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Cherry");
        list.add("Banana");
        System.out.println("List: "+list);
        LinkedList<String> clonedList = (LinkedList<String>) list.clone();
        System.out.println("Cloned: "+clonedList);
    }
}
