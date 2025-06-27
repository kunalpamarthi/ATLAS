import java.util.Scanner;

public class _4_Sudoku {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
//                System.out.print("Enter element :");
//                sudoku[i][j] = scanner.nextInt();
                sudoku[i][j] = j;
            }
        }

        System.out.println("\n\t┌-----------┬-----------┬-----------┐");
        for (int i=0; i<9; i++){
            System.out.print("\t|");
            for(int j=0; j<9; j++){
                System.out.print("\s\s"+ sudoku[i][j]);
                if (((j + 1) % 3 == 0)) {
                    System.out.print("\t|");
                }
            }
            System.out.println();
            if (((i + 1) % 3 == 0)) {
                if(i==8){
                    System.out.print("\t└-----------┴-----------┴-----------┘\n");
                }
                else
                    System.out.print("\t├-----------┼-----------┼-----------┤\n");
            }

        }

        scanner.close();
    }
}
