class Node{
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyList{
    Node head;
    SinglyList(){
        this.head = null;
    }

    void insertData(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void traverseList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print(current);
    }
}

class DoubleNode{
    String data;
    DoubleNode next;
    DoubleNode prev;

    public DoubleNode(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyList{
    DoubleNode head;
    DoubleNode tail;
    DoublyList(){
        this.head = null;
        this.tail = null;
    }

    void insertData(String data){
        DoubleNode newNode = new DoubleNode(data);
        if (head == null){
            head = newNode;
            tail = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void traverseForward(){
        DoubleNode current = head;
        while (current != null){
            System.out.print(current.data + "<->");
            current = current.next;
        }
        System.out.print(current);
    }
    void traverseBack(){
        DoubleNode current = tail;
        while (current != null){
            System.out.print(current.data + "<->");
            current = current.prev;
        }
        System.out.print(current);
    }
}

class CircleList{
    Node head;
    CircleList(){
        this.head = null;
    }

    void insertDataSing(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            newNode.next = head;
        }
        else {
            Node current = head;
            while (current.next != head){
                current = current.next;
            }
            newNode.next = head;
            current.next = newNode;
        }
    }

    void traverseForward(){
        Node current = head;
        int count = 0;
        if (head != null){
            while (current.next != null) {
                System.out.print(current.data + "->");
                current = current.next;
                if (current == head) count++;
                if (count > 0) break;
            }
            System.out.print(current.data + "(head)");
        }
        else System.out.println("List is empty!!");
    }
}

public class DS_Lists {

    public static void main(String[] args) {
    /* implement singly and doubly linked list and insert:
     Alice -> Bob -> Charlie -> null */

        SinglyList singlyList = new SinglyList();
        singlyList.insertData("Alice");
        singlyList.insertData("Bob");
        singlyList.insertData("Charlie");
        singlyList.traverseList();
        System.out.println();

        DoublyList doublyList = new DoublyList();
        doublyList.insertData("Alice");
        doublyList.insertData("Bob");
        doublyList.insertData("Charlie");
        doublyList.traverseForward();
        System.out.println();
        doublyList.traverseBack();
        System.out.println();

        CircleList circleList = new CircleList();
        circleList.insertDataSing("1");
        circleList.insertDataSing("2");
        circleList.insertDataSing("3");
        circleList.insertDataSing("4");
        circleList.traverseForward();
    }
}
