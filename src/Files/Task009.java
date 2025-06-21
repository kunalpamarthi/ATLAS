// Task009: lambda expressions

package Files;

import java.lang.FunctionalInterface;

@FunctionalInterface
interface MyInterface{
    double getPiValue();
}

public class Task009 {
    public static void main( String[] args ) {
        MyInterface ref;
        ref = () -> 3.1415; // lambda exp
        System.out.println("Value of Pi = " + ref.getPiValue());
    }
}
