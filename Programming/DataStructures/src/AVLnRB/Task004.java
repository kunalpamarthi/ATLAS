// Task004: Red-Black tree.

package AVLnRB;

class RedBlackTree {
    Node root;
    private static class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        boolean isRed;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
            this.isRed = true;
        }
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }
        x.right = y;
        y.parent = x;
    }


    private void fixInsertion(Node k) {

//        No two adjacent nodes should be red
        while (k.parent != null && k.parent.isRed) {
//            Left branch
            if (k.parent == k.parent.parent.left) {
                Node y = k.parent.parent.right;

//                Red Aunt Color Exchange
                if (y != null && y.isRed) {
                    k.parent.isRed = false;
                    y.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                }

//                Black Aunt Rotate
                else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    rightRotate(k.parent.parent);
                }
            }

//            Right branch
            else {
                Node y = k.parent.parent.left;

//                Red Aunt Color Exchange
                if (y != null && y.isRed) {
                    k.parent.isRed = false;
                    y.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                }

//                Black Aunt Rotate
                else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    leftRotate(k.parent.parent);
                }
            }
        }
        root.isRed = false;
    }


    public void insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        }
        else {
            Node y = null;
            Node x = root;
            while (x != null) {
                y = x;
                if (node.data < x.data) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
            node.parent = y;
            if (node.data < y.data) {
                y.left = node;
            } else {
                y.right = node;
            }
        }
//        root is always black
        if (node.parent == null) {
            node.isRed = false;
            return;
        }
        if (node.parent.parent == null) {
            return;
        }
        fixInsertion(node);
    }


    public void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }
            String color = node.isRed ? "RED" : "BLACK";
            System.out.println(node.data + "(" + color + ")");
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
}

public class Task004 {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
            if (i==4) break;
        }
        tree.insert(9);
        tree.insert(6);
        tree.insert(10);
        tree.insert(5);
        System.out.println("Red-black tree: ");
        tree.printTree(tree.root, "", true);
    }
}
