// Task008: update the 1st element to a new value

package LinkedLists;

import java.util.NoSuchElementException;

class UpCustomList<T> extends RemLastLinkedList<T>{
    public void replace(int position, T value){
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        GNode<T> current = head;
        for (int j = 1; j < position; j++) {
            current = current.next;
        }
        current.data = value;
    }
}

public class Task008 {
    public static void main(String[] args) {
        UpCustomList<String> list = new UpCustomList<>();
        list.add("One  ");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"->");
        }
        System.out.println("Null");
        list.replace(1, "First");
        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"->");
        }
        System.out.println("Null");
        System.out.println("Updated first element to "+list.get(0));
    }
}
