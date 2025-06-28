// Task004: Try to create a node and add a value to it.
// Which can take any kind of data in the Node.

package LinkedLists;

import java.util.NoSuchElementException;

class GNode<T> {
    T data;
    GNode<T> next;

    public GNode(T data) {
        this.data = data;
        this.next = null;
    }
}
class CustomLinkedList<T> {
    private GNode<T> head;
    private int size = 0;

    public void add(T data) {
        GNode<T> newNode = new GNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            GNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        GNode<T> newNode = new GNode<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    public T get(int index) {
        checkBounds(index);
        GNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}

public class Task004 {
    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Kunal");
        customLinkedList.add("Shiro");
        customLinkedList.add("Goboy");
        for (int i = 0; i < customLinkedList.size(); i++) {
            System.out.print(customLinkedList.get(i)+"->");
        }
        System.out.println("NULL");
        System.out.println("Replace: "+customLinkedList.removeFirst()+" x Etherious.");
        customLinkedList.addFirst("Etherious");
        for (int i = 0; i < customLinkedList.size(); i++) {
            System.out.print(customLinkedList.get(i)+"->");
        }
        System.out.println("NULL");
    }
}
