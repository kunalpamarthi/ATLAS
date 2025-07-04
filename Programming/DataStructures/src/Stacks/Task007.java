// Task007: Peek the element and print it.

package Stacks;

import java.util.Stack;

public class Task007 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.println(stack);
        String topElement = stack.peek();
        System.out.println("Top element: "+topElement);
    }
}
