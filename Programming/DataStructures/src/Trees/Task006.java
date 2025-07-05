// Task006: Binary searching.

package Trees;

class Searching extends Traversal{
    public Node search(int data){
        Node current = root;
        while (current != null){
            if (current.data == data){
                return current;
            } else if (current.data < data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }
}

public class Task006 {
    public static void main(String[] args) {
        Searching searching = new Searching();
        int[] arr = {5, 1, 6, 4, 3, 2, 8, 7};
        for (int a:arr){
            searching.insert(a);
        }
        Node node = searching.search(4);
        System.out.println("Required data -> \t\t"+node.data);
        System.out.println("\t\t\t\t\t/\t\t\\");
        System.out.println(node.left +"  \t\t "+ node.right);
    }
}
