import java.util.Arrays;

class Bubble{
    public int[] sort(int[] array){
        int temp, swap;

        for(int i=0; i<array.length-1; i++){
            swap = 0;
            for (int j=0; j<array.length-1; j++){
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    swap = 1;
                }
            }
            if (swap == 0) return array;
        }
        return array;
    }
}

class Insertion{
    public int[] sort(int[] array){
        int key, j;
        for (int i=1; i<array.length; i++){
            key = array[i];
            j = i-1;
            while (j >= 0 && array[j]>key){
                array[j+1] = array[j];
                j-=1;
            }
            array[j+1] = key;
        }
        return array;
    }
}

class Merge{
    private void merge(int[] arr, int left, int mid, int right){
        int n1 = mid-left + 1;
        int n2 = right-mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid+1, rightArr, 0, n2);

        int i=0, j=0;
        int k=left;
        while (i<n1 && j<n2){
            if (leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }
    public void sort(int[] arr, int left, int right){
        if (left<right){
            int mid = (left + right)/2;

            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
}

class Quick{

    void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public void sort(int[] arr, int low, int high){
        if (low<high){
            int pivotIndex = partition(arr, low, high);

            sort(arr, low, pivotIndex-1);
            sort(arr, pivotIndex+1, high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for (int j=low; j<high; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
}

public class DS_Sorts {
    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        Insertion insertion = new Insertion();
        Merge merge = new Merge();
        Quick quick = new Quick();

        int[] arr = {5, 8, 9, 1, 0, 6};
        int[] insArr = {3, 4, 1, 6, 11, 134};
        int[] mergeArr = {2, 5, 1, 6, 32, 98, 91, 3, 13};
        int[] quickArr = {89, 0, 187, 32, 78, 98, 1, 43, 461};

        System.out.println(Arrays.toString(bubble.sort(arr)));
        System.out.println(Arrays.toString(insertion.sort(insArr)));
        merge.sort(mergeArr, 0, mergeArr.length-1);
        System.out.println(Arrays.toString(mergeArr));
        quick.sort(quickArr, 0, quickArr.length-1);
        System.out.println(Arrays.toString(quickArr));

    }
}
