import java.util.EmptyStackException;

class Queue{
    private int top;
    private final int capacity;
    private final String[] queue;
    private int size;
    private int front;

    Queue(int capacity){
         top = -1;
         queue = new String[capacity];
         this.capacity = capacity;
    }

    public void enqueue(String data){
        if (isFull()){
            System.out.println("Queue is full!!");
            return;
        }
        if (isEmpty()){
            top = 0;
            front = 0;
        }
        else {
            top = (top+1)%capacity;
        }
        queue[top] = data;
        size++;
    }

    public String dequeue(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        String frontData = queue[front];
        if (front == top){
            top = -1;
            front = -1;
        }
        else {
            front = (front+1)%capacity;
        }
        size--;
        return frontData;
    }

    public int peek(){
        if (isEmpty()) return -1;
        return front;
    }

    public int size(){ return size;}
    public boolean isEmpty(){ return (size == 0);}
    public boolean isFull(){ return (capacity == size);}

    public void display(){
        System.out.println("Queue: ");
        if (isEmpty()) return;
        int i=front;
        while (i != (top+1)%capacity){
            System.out.print("\t"+queue[i]);
            i = (i+1)%capacity;
        }
        System.out.println();
    }

}

public class DS_Queues {
    public static void main(String[] args) {
        Queue circle = new Queue(10);
        circle.enqueue("10");
        circle.enqueue("20");
        circle.enqueue("30");
        circle.enqueue("40");
        circle.enqueue("50");
        circle.display();
        circle.dequeue();
        circle.dequeue();
        circle.display();
        circle.enqueue("60");
        circle.enqueue("70");
        circle.display();
        System.out.println("\nRecent dequeue: " + circle.dequeue()+ "\nPeek: " + circle.peek() + "\nsize: " + circle.size());
    }
}
