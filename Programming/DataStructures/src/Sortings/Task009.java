// Task009: Insertion sort.

package Sortings;

public class Task009 {
    public static void main(String[] args) {
        int[] sortArr, arr = {4, 8, 1, 3, 2, 9, 7, 8, 4, 5, 6};
        System.out.print("Unsorted: ");
        for (int a: arr) System.out.print(a+" ");
        System.out.print("\n Sorted:  ");
        sortArr = insertionSort(arr);
        for (int a: sortArr) System.out.print(a+" ");
    }

    private static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while ((j >= 0) && (arr[j]>key)){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return arr;
    }
}
