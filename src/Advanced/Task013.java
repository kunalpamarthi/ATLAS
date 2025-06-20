// Task013: Interruptions.

package Advanced;

class InterruptibleThread extends Thread {
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running");
                //noinspection BusyWait
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }
}

public class Task013 {
    public static void main(String[] args) {
        InterruptibleThread thread = new InterruptibleThread();
        thread.start();

        try {
            Thread.sleep(500);
            thread.interrupt();
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}

