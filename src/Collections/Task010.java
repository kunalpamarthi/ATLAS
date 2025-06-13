// Task010: add, remove and set methods from ArrayList.

package Collections;

import java.util.ArrayList;

public class Task010 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("shiro");
        al.add("kunal");
        System.out.println("Original List: "+al);

        al.add(1, "Hello");
        System.out.println("After Adding element at index 1: "+ al);

        al.remove(0);
        System.out.println("Element removed from index 0: "+ al);

        al.remove("kunal");
        System.out.println("Element kunal removed: "+ al);

        al.set(0, "K");
        System.out.println("List after update: "+al);

    }
}
