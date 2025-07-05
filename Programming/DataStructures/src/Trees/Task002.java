// Task002: Create a class named Binary Search tree
// in which you have 2 insert operations

package Trees;

class BSTree{
    Node root;

    public void insert(int data){
        root = insertNode(root, data);
    }

    private Node insertNode(Node node, int data){
        if (node == null){
            return new Node(data);
        }
        if (data < node.data){
            node.left = insertNode(node.left, data);
        } else {
            node.right = insertNode(node.right, data);
        }

        return node;
    }

}

public class Task002 {
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        int[] arr = {5, 1, 6, 4, 3, 2, 8, 7};
        for (int a:arr){
            bsTree.insert(a);
        }
        System.out.println("Created BS tree and inserted nodes.");
    }
}
