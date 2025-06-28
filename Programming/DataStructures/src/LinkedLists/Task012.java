// Task012: Use pop and push methods on linked list.

package LinkedLists;

import java.util.LinkedList;

public class Task012 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.push("One");
        list.push("Two");
        list.push("Three");
        list.push("Four");
        list.push("Five");
        System.out.print("List: NULL");
        for (String s : list) {
            System.out.print("->"+s);
        }
        System.out.println();
        list.pop();
        list.push("Six");
        System.out.print("List: NULL");
        for (String s : list) {
            System.out.print("->"+s);
        }
        System.out.println();
    }
}
