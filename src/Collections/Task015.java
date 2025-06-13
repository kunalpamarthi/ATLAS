// Task015:

package Collections;

class Outer {
    int x = 10;
    static class InnerClass {
        static int y = 5;
    }
}

public class Task015 {
    public static void main(String[] args) {
        Outer.InnerClass innerClass = new Outer.InnerClass();
        System.out.println(innerClass.y);
    }
}
