// Task010: Create a queue with custom methods.

package Stacks;

class Queue<X>{
    Node<X> front, rear;
    int size, cap;

    public Queue(int cap){
        this.cap = cap;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    public void enqueue(X data){
        if (isFull()){
            System.out.println("Reached capacity!!");
            return;
        }
        Node<X> node = new Node<>(data);
        if (rear == null){
            front = node;
        } else {
            rear.next = node;
        }
        rear = node;
        size++;
    }

    public X dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty.");
            return null;
        }

        X data = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        size--;
        return data;
    }

    public X peek(){
        if (rear == null){
            System.out.println("Queue is empty.");
            return null;
        }
        return front.data;
    }

    public void display(){
        System.out.print("start-< ");
        Node<X> current = front;
        while (current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println(">-end");
    }

    public boolean isFull(){
        return size == cap;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}

public class Task010 {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>(5);
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        queue.display();
        System.out.println("Top element: "+queue.peek());
        System.out.println(("Dequeued element: "+queue.dequeue()));
        queue.display();

    }
}
