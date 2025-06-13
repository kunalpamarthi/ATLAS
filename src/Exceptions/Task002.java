//Task002: Include try catch blocks.

package Exceptions;

public class Task002 {
    public static void main(String[] args) {
        try {
            int[] num = {1, 2, 3};
            System.out.println(num[5]);
        }catch (Exception e){
            System.out.println("Something went wrong!! ");
        }
    }
}
