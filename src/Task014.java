/*
Task 014
Arrays: Try the below code and display the output.
Now play with it try to access arr of 5th index and see the output
and try to access arr of -1 index and see the output.
*/

public class Task014 {
    public static void main(String[] args) {
        char[] arr = {'a','e','i','o','u'};
        System.out.println(arr);
        String[] names = {"Meena", "Tina", "Veena", "heena"};
        System.out.println(names[0]);
        names[1]= "Reena";
        System.out.println(names[1]);
        System.out.println(names.length);
        System.out.println(names[4]);
        System.out.println(names[5]); // Try to access arr of 5th index.
        System.out.println(names[-1]); // Try to access arr of -1 index.
    }
}
