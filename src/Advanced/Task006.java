// Task006: Threads Synchronization

package Advanced;

class SyncCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class SyncThreadDemo extends Thread {
    SyncCounter counter;

    SyncThreadDemo(SyncCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

public class Task006 {
    public static void main(String[] args) {
        SyncCounter counter = new SyncCounter();
        SyncThreadDemo t1 = new SyncThreadDemo(counter);
        SyncThreadDemo t2 = new SyncThreadDemo(counter);

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
