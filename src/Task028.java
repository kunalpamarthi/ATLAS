// Task028: Array return type.

public class Task028 {
    static int[] prime(int[] arr){
        int[] primeArr = new int[arr.length];
        for (int j=0; j<arr.length; j++){
            for (int i = 2; i <= arr[j]/2; i++) {
                if (arr[j]%i == 0){
                    primeArr[j] = 1;
                    break;
                }
            }
        }
        return primeArr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2, 9};
        int[] primePos = prime(arr);
        for (int a: primePos){
            System.out.print(a+" ");
        }
    }
}
