// Task005: Try multiple catch blocks.

package Exceptions;

public class Task005 {
    public static void main(String[] args) {
        try{
            int[] arr = new int[7];
            int a = 5, b = 0, c;
            c = a / b;
            arr[c + 10] = 10;
            System.out.println(c + arr[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index out of bounds: "+ e);
        }catch (Exception e){
            System.out.println("Exception thrown: "+ e);
        }finally {
            System.out.println("Finally");
        }
    }
}
