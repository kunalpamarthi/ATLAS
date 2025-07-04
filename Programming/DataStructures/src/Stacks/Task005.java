// Task005: Create a stack, pop the element and print it.

package Stacks;

import java.util.Stack;

public class Task005 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.println(stack);
        System.out.println("Top element: "+stack.peek());
        System.out.println("Popped element: "+stack.pop());
        System.out.println("Pushed: "+stack.push("end."));
        System.out.println(stack);
    }
}
