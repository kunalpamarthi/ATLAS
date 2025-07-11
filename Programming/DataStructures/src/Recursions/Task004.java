// HomeTask004: Reverse a string using recursion.

package Recursions;

public class Task004 {
    public static void main(String[] args) {
        String rev, str = "Hello";
        rev = reverseStr(str);
        System.out.println(rev);
    }

    private static String reverseStr(String str) {
        if (str.length() == 1){
            return str;
        } else {
            return reverseStr(str.substring(1)) + str.charAt(0);
        }
    }
}
