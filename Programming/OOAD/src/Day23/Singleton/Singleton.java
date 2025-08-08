// Task003: Singleton

package Day23.Singleton;

class SingletonDemo {
    private static SingletonDemo instance; // login ids.. //pass/ pin no
    private SingletonDemo() {
        System.out.println("initiating the singleton");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
            System.out.println("in get instance");
        }
        return instance;
    }
    public static void doHere() {
        System.out.println("doing here some thing");
    }
}

public class Singleton {
    public static void main(String[] args) {
        SingletonDemo.getInstance().doHere();
    }
}
