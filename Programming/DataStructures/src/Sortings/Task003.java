// Task003: Selection sort

package Sortings;

public class Task003 {
    public static void main(String[] args) {
        int[] sortArr, arr = {4, 8, 1, 3, 2, 9, 7, 8, 4, 5};
        System.out.print("Unsorted: ");
        for (int a: arr) System.out.print(a+" ");
        sortArr = selectionSort(arr);
        System.out.print("\nSorted:   ");
        for (int a: sortArr) System.out.print(a+" ");
    }

    private static int[] selectionSort(int[] arr) {
        for (int i=0; i< arr.length-1; i++){
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
