import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Objects;

class DynamicArrayStack{
    private int top;
    private String[] stack;
    private int capacity;

    public DynamicArrayStack(int capacity){
        this.capacity = capacity;
        stack = new String[capacity];
        top = -1;
    }

    public void push(String data){
        if (isFull()){
            capacity *= 2;
            String[] tempStack = new String[capacity];
            System.arraycopy(stack, 0, tempStack, 0, stack.length);
            stack = tempStack;
        }
        stack[++top] = data;
    }

    public String pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    public String peek(){
        return stack[top];
    }

    boolean isEmpty(){
        return (top == -1);
    }
    boolean isFull(){
        return (capacity == top+1);
    }
}

public class DS_Stacks {

    public static int precedence(char operator){
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static String infixToPostfix(String infix){
        StringBuilder post = new StringBuilder();
        LinkedList <String> expStack = new LinkedList<>();
        for (char c: infix.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                post.append(c);
            }
            else if (c == '('){
                expStack.push(String.valueOf(c));
            }
            else if (c == ')') {
                while ((!Objects.equals(expStack.peek(), "(")) && !expStack.isEmpty()){
                    post.append(expStack.peek());
                    expStack.pop();
                }
                expStack.pop();
            }
            else {
                while (!expStack.isEmpty() && (precedence(c) <= precedence(expStack.peek().charAt(0)))){
                    post.append(expStack.peek());
                    expStack.pop();
                }
                expStack.push(String.valueOf(c));
            }
        }

        while (!expStack.isEmpty()){
            if (expStack.peek().equals("(")) return "Invalid Expression!!";
            post.append(expStack.peek());
            expStack.pop();
        }

        return post.toString();
    }

    public static String reverse(String string){
        StringBuilder revString = new StringBuilder();
        LinkedList<String> stringStack = new LinkedList<>();
        for(char c: string.toCharArray()){
            stringStack.push(String.valueOf(c));
        }
        while(!stringStack.isEmpty()){
            revString.append(stringStack.peek());
            stringStack.pop();
        }
        return revString.toString();
    }

    public static void main(String[] args) {

        String top, poppedItem;

        DynamicArrayStack dynamicArrayStack = new DynamicArrayStack(10);
        dynamicArrayStack.push("30");
        dynamicArrayStack.push("20");
        dynamicArrayStack.push("10");
        top = dynamicArrayStack.peek();
        poppedItem = dynamicArrayStack.pop();
        System.out.println(top +"\n"+ poppedItem +"\n");
        poppedItem = dynamicArrayStack.pop();
        System.out.println(poppedItem);
        dynamicArrayStack.push("10");
        top = dynamicArrayStack.peek();
        System.out.println(top);


        String post = infixToPostfix("a+(b*c)");
        System.out.println(post);


        System.out.println(reverse("321"));
    }
}
