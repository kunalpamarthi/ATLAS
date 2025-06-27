public class DS_Searching {

    public static int linear(int[] arr, int ele){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == ele) return i;
        }
        return -1;
    }

    public static int binaryIteration(int[] arr, int target){
        int left = 0, right = arr.length-1;
        int mid = left + (right-left)/2;
        while (mid >= 0){
            if (target == arr[mid]){
                return mid;
            }else if (target > arr[mid]){
                left = mid+1;
                mid = left + (right-left)/2;
            }else {
                right = mid-1;
                mid = left + (right-left)/2;
            }
        }
        return -1;
    }

    public static int binaryRecursion(int[] arr, int left, int right, int target){
        if (left > right) return -1 ;
        int mid = left + (right-left)/2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binaryRecursion(arr, mid+1, right, target);
        else return binaryRecursion(arr, left, mid-1, target);
    }

    public static void main(String[] args) {
        int[] arr = {32, 5, 78, 91, 678};
        int linearIndex = linear(arr, 5);
        int binaryIndex = binaryIteration(arr, 91);
        int binaryRec = binaryRecursion(arr, 0, arr.length-1, 678);

        System.out.println((linearIndex == -1)? "Element does not available in the array!!" : linearIndex);
        System.out.println((binaryIndex == -1)? "Element does not available in the array!!" : binaryIndex);
        System.out.println((binaryRec == -1)? "Element does not available in the array!!" : binaryRec);
    }
}
