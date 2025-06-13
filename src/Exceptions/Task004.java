//Task004: Accessing elements of the array.

package Exceptions;

public class Task004 {
    public static void main(String[] args) {
        try {
            int[] num = {1, 2, 3};
            System.out.println(num[2]+"\n"+num[1]);
        }catch (Exception e){
            System.out.println("Something went wrong!! ");
        }finally {
            System.out.println("This is from finally block.");
        }
    }
}
