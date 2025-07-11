// HomeTask002: Find the Fibonacci number

package Recursions;

public class Task002 {
    public static void main(String[] args) {
        int fib = fibanocci(6);
        System.out.println(fib);
    }

    private static int fibanocci(int num) {
        if (num <= 0){
            throw new IllegalArgumentException("Incorrect number");
        } else if (num == 1) {
            return 0;
        } else if(num == 2){
            return 1;
        } else{
            return fibanocci(num-1)+fibanocci(num-2);
        }
    }
}
