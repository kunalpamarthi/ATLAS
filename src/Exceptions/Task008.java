// Task008: Custom exceptions.

package Exceptions;

class MyException extends Exception {
    public MyException(String m) {
        super(m);
    }
}

public class Task008 {
    public static void main(String[] args) {
        try {
            throw new MyException("This is a custom exception");
        } catch (MyException ex) {
            System.out.println("Caught");
            System.out.println(ex.getMessage());
        }
    }
}
