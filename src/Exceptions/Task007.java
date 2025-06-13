// Task007: Throw an exception.

package Exceptions;

public class Task007 {

    static void fun(int a, int b){
        if (b == 0){
            throw new ArithmeticException("Division by zero exception.");
        }
    }

    public static void main(String[] args) {
        int a=4, b=0;
        try {
            fun(a, b);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
