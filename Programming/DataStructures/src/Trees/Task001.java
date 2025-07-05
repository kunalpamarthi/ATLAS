// Task001: Create a node for a tree and include a constructor.

package Trees;

class Node<T>{
    T data;
    Node<T> left, right;
    public Node(T data){
        this.right = null;
        this.left = null;
        this.data = data;
    }

    void display(){
        System.out.println("Node is created.");
    }
}

public class Task001 {
    public static void main(String[] args) {
        Node<String> node = new Node<>(" ");
        node.display();
    }
}
