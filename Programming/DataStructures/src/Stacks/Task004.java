// Task004: Delete a node in the circular linked list.

package Stacks;

class DeleteCircleNode<T> extends CircleList<T>{
    public void deleteNode(T data){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }
        if (head.data == data){
            if (head.next == head){
                head = null;
                return;
            }
            Node<T> current = head;
            while (current.next != head){
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != head){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

public class Task004 {
    public static void main(String[] args) {
        DeleteCircleNode<String> list = new DeleteCircleNode<>();
        list.addCircleNode("one");
        list.addCircleNode("two");
        list.addCircleNode("three");
        list.addCircleNode("four");
        list.addCircleNode("five");
        list.traverseCircle();
        System.out.println();
        list.deleteNode("three");
        list.traverseCircle();
    }
}
