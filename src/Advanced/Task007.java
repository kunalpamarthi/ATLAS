// Task006: Threads Synchronization block

package Advanced;

class SyncBlockCounter {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }


    public int getCount() {
        return count;
    }
}

class SyncBlockThreadDemo extends Thread {
    SyncBlockCounter counter;

    SyncBlockThreadDemo(SyncBlockCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

public class Task007 {
    public static void main(String[] args) {
        SyncBlockCounter syncBlockCounter = new SyncBlockCounter();
        SyncBlockThreadDemo t1 = new SyncBlockThreadDemo(syncBlockCounter);
        SyncBlockThreadDemo t2 = new SyncBlockThreadDemo(syncBlockCounter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        System.out.println("Final count: " + syncBlockCounter.getCount());
    }
}
