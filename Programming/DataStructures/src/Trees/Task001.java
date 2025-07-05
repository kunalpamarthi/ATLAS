// Task001: Create a node for a tree and include a constructor.

package Trees;

class Node{
    int data;
    Node left, right;
    public Node(int data){
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
        Node node = new Node(1);
        node.display();
    }
}
