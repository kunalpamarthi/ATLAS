// Task014: Merge sort.

package Sortings;

public class Task014 {
    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        System.arraycopy(arr, low, left, 0, mid - low + 1);
        System.arraycopy(arr, mid + 1, right, 0, high - mid);

        int i = 0, j = 0, k = low;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 1, 3, 2, 9, 7, 8, 4, 5, 6};
        System.out.print("Unsorted: ");
        for (int a: arr) System.out.print(a+" ");
        System.out.print("\n Sorted:  ");
        mergeSort(arr, 0, arr.length-1);
        for (int a: arr) System.out.print(a+" ");
    }
}
