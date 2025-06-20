// Task005: Threads

package Advanced;

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class newThreadDemo extends Thread {
    Counter counter;

    newThreadDemo(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

public class Task005 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        newThreadDemo t1 = new newThreadDemo(counter);
        newThreadDemo t2 = new newThreadDemo(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
