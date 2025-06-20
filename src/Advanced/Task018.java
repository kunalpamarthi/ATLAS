// Task018: Debugging.

package Advanced;

class Test extends Thread{
    public void run(){
        System.out.println("thread started.");
    }
}

public class Task018 {
    public static void main(String[] args){

        Test t1 = new Test();
        t1.start();
    }
}

