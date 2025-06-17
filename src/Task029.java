// Task029: Cloning of 1D Array.

public class Task029 {
    public static void main(String[] args) {
        int []arr = {3, 8, 4};
        int[] cloneArr = arr.clone();
        System.out.println((arr == arr)+"  "+(cloneArr == arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"\t\t"+cloneArr[i]);
        }
    }
}
