//Task013: WAP to display numbers from 10 to 1 . skip 7 and 5.

public class Task013 {
    public static void main(String[] args) {
        for(int i=10; i>0; i--) {
            if (i==5 || i==7) continue;
            System.out.println(i);
        }
    }
}
