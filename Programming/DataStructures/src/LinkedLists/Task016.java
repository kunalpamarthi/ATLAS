// Task016: Create a doubly linked list.

package LinkedLists;

class DoublyLinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }

    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

public class Task016 {
    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        int size = doublyLinkedList.getSize();
        doublyLinkedList.add("one");
        doublyLinkedList.add("two");
        doublyLinkedList.add("three");
        doublyLinkedList.printBackward();
        doublyLinkedList.removeFirst();
        doublyLinkedList.addFirst("four");
        doublyLinkedList.removeLast();
        doublyLinkedList.add("five");
        doublyLinkedList.printForward();
        System.out.println("Size of the list: "+size);
    }
}
