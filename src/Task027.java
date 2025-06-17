// Task027: Array as parameter

public class Task027 {
    static void sum(int[] arr){
        int sum = 0;
        for (int a: arr){
            sum += a;
        }
        System.out.println("Sum of the array: "+ sum);
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 3, 5};
        sum(arr);
    }
}
