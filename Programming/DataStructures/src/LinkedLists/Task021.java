// Task021: use custom method of creating a circular
// linked list and traverse the elements

package LinkedLists;

class CircularLinkedList{
    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class Task021 {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        for (int i = 1; i <= 10; i++) {
            circularLinkedList.add(i*i);
        }
        circularLinkedList.traverse();
    }
}
