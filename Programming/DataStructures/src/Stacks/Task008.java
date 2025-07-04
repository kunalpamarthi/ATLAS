// Task008: Check if the stack is empty or not?

package Stacks;

import java.util.Stack;

public class Task008 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        System.out.println(stack);
        String topElement = stack.peek();
        System.out.println("Top element: "+topElement);
        while (!stack.isEmpty()){
            System.out.println("Popping: "+stack.pop());
        }
        System.out.println("Stack is empty: " + stack);
    }
}
