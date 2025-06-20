// Task008: Threads Static Synchronization

package Advanced;

class StaticSyncCounter {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}

class StaticSyncThreadDemo extends Thread {
    StaticSyncCounter counter;

    StaticSyncThreadDemo(StaticSyncCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

public class Task008 {
    public static void main(String[] args) {
        StaticSyncCounter staticSyncCounter = new StaticSyncCounter();
        StaticSyncThreadDemo t1 = new StaticSyncThreadDemo(staticSyncCounter);
        StaticSyncThreadDemo t2 = new StaticSyncThreadDemo(staticSyncCounter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        System.out.println("Final count: " + staticSyncCounter.getCount());
    }
}
