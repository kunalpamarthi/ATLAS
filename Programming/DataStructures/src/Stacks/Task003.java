// Task003: Create a Circular Linked list using Task 1.

package Stacks;

class CircleList<T> extends LinkedList<T>{
    public void addCircleNode(T data) {
        Node<T> node = new Node<>(data);

        if(head == null){
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.next = head;
    }

    public void traverseCircle(){
        Node<T> current = head;
        int index=1;
            do {
                System.out.println("Element at index "+index+": "+current.data);
                current = current.next;
                index++;
            }while (current != head);
    }
}

public class Task003 {
    public static void main(String[] args) {
        CircleList<String> circleList = new CircleList<>();
        circleList.addCircleNode("one");
        circleList.addCircleNode("two");
        circleList.addCircleNode("three");
        circleList.traverseCircle();
    }
}
