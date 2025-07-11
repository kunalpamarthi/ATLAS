/* Task011:
This code is going overflow of stack.
Can you plz help me fix it guys

public class RecLoop {
     public int calc(int n) {
        if (n == 0) return 0;
        return n + calc(n);
    } */

//"calc() method is used to calculate sum of first n numbers by recursion."
//"Problem in the given method is parameter remains same in the further calls."


package Sortings;

public class Task011 {

        public static int calc(int n) {
            if (n == 0) return 0;
            return n + calc(n-1);
        }

    public static void main(String[] args) {
            int n = 10;
            int sum = calc(10);
            System.out.println("Sum of first "+n+" numbers is: "+sum);
    }
}
