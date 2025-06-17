// Task026: Traverse multidimensional array.

public class Task026 {
    public static void main(String[] args) {
        int[][] dialPad = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0, 0, 0}};

        for (int i = 0; i < dialPad.length; i++) {
            for (int j = 0; j < dialPad[0].length; j++) {
                System.out.print(dialPad[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
