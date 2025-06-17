// Task030: Cloning 2D array.

public class Task030 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] cloneArr = arr.clone();
        System.out.println(arr == cloneArr);
        System.out.println(arr[0] == cloneArr[0]);
    }
}
