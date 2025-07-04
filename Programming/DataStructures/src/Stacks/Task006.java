// Task006: Find an element in the stack and display the position.

package Stacks;

import java.util.Stack;

public class Task006 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("apple");
        stack.push("guava");
        stack.push("mango");
        stack.push("monkey");
        stack.push("guitar");
        System.out.println(stack);
        int position = stack.search("monkey");
        System.out.println("Monkey's position in the stack: "+position);
    }
}
