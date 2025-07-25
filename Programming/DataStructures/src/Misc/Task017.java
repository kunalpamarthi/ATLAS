// Task017: Radix sort

package Misc;

import java.util.*;

public class Task017 {
    public static void main(String[] args) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 1; i <16; i++) {
            Node node = new Node(i);
            queue.add(node);
        }


        System.out.println("Peek: "+queue.peek().key);
        System.out.println("Poll: "+queue.poll());
        System.out.println("Peek: "+queue.peek().key);

    }
}
