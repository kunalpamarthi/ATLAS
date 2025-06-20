// Task009: Threads Lock Synchronization

package Advanced;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockSyncCounter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    public int getCount() {
        return count;
    }

}

class LockSyncThreadDemo extends Thread {
    LockSyncCounter counter;

    LockSyncThreadDemo(LockSyncCounter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

public class Task009 {
    public static void main(String[] args) {
        LockSyncCounter lockSyncCounter = new LockSyncCounter();
        LockSyncThreadDemo t1 = new LockSyncThreadDemo(lockSyncCounter);
        LockSyncThreadDemo t2 = new LockSyncThreadDemo(lockSyncCounter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        System.out.println("Final count: " + lockSyncCounter.getCount());
    }
}
