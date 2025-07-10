// HomeTask001: Find the factorial of a number.

package Recursions;

public class Task001 {
    public static void main(String[] args) {
        int fact = fact(5);
        System.out.println("Factorial: "+fact);
    }

    private static int fact(int num) {
        if (num < 2){
            return num;
        }
        return num*fact(num-1);
    }
}
