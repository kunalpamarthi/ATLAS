// Task017: Quick sort.

package Sortings;

public class Task017 {

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot  = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 1, 3, 2, 9, 7, 8, 4, 5, 6};
        System.out.print("Unsorted: ");
        for (int a: arr) System.out.print(a+" ");
        System.out.print("\n Sorted:  ");
        quickSort(arr, 0, arr.length-1);
        for (int a: arr) System.out.print(a+" ");
    }
}
