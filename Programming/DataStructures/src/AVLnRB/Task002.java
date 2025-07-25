// Task002: AVL tree insertion.

package AVLnRB;

class Node {
    int key, height;
    Node left, right;
    Node (int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {
    Node root;
    int height (Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max (int a, int b) {
        return Math.max(a, b);
    }

    Node rightRotate (Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max (height (y.left), height (y.right)) + 1;
        x.height = max (height (x.left), height (x.right)) + 1;
        return x;
    }

    Node leftRotate (Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max (height (x.left), height (x.right)) + 1;
        y.height = max (height (y.left), height (y.right)) + 1;
        return y;
    }

    int getBalance (Node N) {
        if (N == null)
            return 0;
        return height (N.left) - height (N.right);
    }

    Node insert (Node node, int key) {
        if (node == null)
            return (new Node (key));

        if (key < node.key)
            node.left = insert (node.left, key);
        else if (key > node.key)
            node.right = insert (node.right, key);
        else
            return node;

        node.height = 1 + max (height (node.left), height (node.right));
        int balance = getBalance (node);
        if (balance > 1 && key < node.left.key)
            return rightRotate (node);

        if (balance < -1 && key > node.right.key)
            return leftRotate (node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate (node.left);
            return rightRotate (node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate (node.right);
            return leftRotate (node);
        }
        return node;
    }

    void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            System.out.println(node.key);
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
}

public class Task002 {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 44);
        tree.root = tree.insert(tree.root, 35);
        tree.root = tree.insert(tree.root, 65);
        tree.root = tree.insert(tree.root, 78);

        System.out.println("AVL Tree: ");
        tree.printTree(tree.root, "", true);
    }
}


