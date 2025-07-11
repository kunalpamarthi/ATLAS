// Task006: Bubble sort

package Sortings;

public class Task006 {
    public static void main(String[] args) {
        int[] sortArr, arr = {4, 8, 1, 3, 2, 9, 7, 8, 4, 5, 6};
        System.out.print("Unsorted: ");
        for (int a: arr) System.out.print(a+" ");
        System.out.print("\n Sorted:  ");
        sortArr = bubbleSort(arr);
        for (int a: sortArr) System.out.print(a+" ");
    }

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
        return arr;
    }
}
