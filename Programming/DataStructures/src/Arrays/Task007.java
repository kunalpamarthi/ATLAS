// Task007: Reverse an array.

package Arrays;

public class Task007 {
    public static void main(String[] args) {
        int[] numArr = {1, 2, 3, 4, 5};
        int temp;
        System.out.print("Given array: \t");
        for (int j : numArr) {
            System.out.print(j);
        }
        for (int i = 0; i < numArr.length/2; i++) {
            temp = numArr[i];
            numArr[i] = numArr[numArr.length-1-i];
            numArr[numArr.length-1-i] = temp;
        }
        System.out.print("\nReversed array: ");
        for (int j: numArr){
            System.out.print(j);
        }
    }
}
