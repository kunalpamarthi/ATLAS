// Task007: remove first and remove last element
// and display all elements in the linked list.

package LinkedLists;

import java.util.NoSuchElementException;

class RemLastLinkedList<T> extends CustomLinkedList<T>{
    public T removeLast() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }

        if (head.next == null) {
            T removedData = head.data;
            head = null;
            size--;
            return removedData;
        }

        GNode<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        T removedData = current.next.data;
        current.next = null;
        size--;
        return removedData;
    }
}

public class Task007 {
    public static void main(String[] args) {
        RemLastLinkedList<String> list = new RemLastLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        System.out.print("List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"->");
        }
        System.out.println("Null");
        String last = list.removeLast();
        String first = list.removeFirst();
        System.out.print("List: \t\t");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"->");
        }
        System.out.println("Null");
        System.out.println("Removed "+first+" and "+last+" from the list.");
    }
}
