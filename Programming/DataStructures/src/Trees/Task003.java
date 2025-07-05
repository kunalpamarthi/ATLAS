// Task003: Inorder traversal.

package Trees;

class Traversal extends BSTree {

    void inorderTraversal() {
        printInorder(root);
    }

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }
}

public class Task003 {
    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        int[] arr = {5, 1, 6, 4, 3, 2, 8, 7};
        for (int a:arr){
            traversal.insert(a);
        }
        traversal.inorderTraversal();
    }
}
