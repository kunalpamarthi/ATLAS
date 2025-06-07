// Interfaces

interface testInterface {
    int tax = 10;
    void display();
}

class TestClass implements testInterface {
    public void display(){
        System.out.println("My class");
        System.out.println("Tax value: "+tax);
    }
}

public class Task041 {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.display();
    }
}
