// Task011: Nested classes.

package Collections;

class OuterClass {
    public static InnerClass InnerClass;
    int x = 10;
    OuterClass(int x){
        this.x = x;
    }

    public class InnerClass {
        int y = 5;
        InnerClass(int y){
            this.y = y;
        }
    }
}

public class Task011 {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass(10);
        OuterClass.InnerClass innerClass = outerClass.new InnerClass(8);
        System.out.println(outerClass.x+innerClass.y);
    }
}
