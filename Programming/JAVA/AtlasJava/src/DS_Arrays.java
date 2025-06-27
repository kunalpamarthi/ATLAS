import java.util.Scanner;
// Explore array methods

public class DS_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no. of students in the class: ");
        int stuCount = scanner.nextInt();
        int[] marksList = new int[stuCount];
        int[][] totalMarkList = new int[stuCount][3];

        for (int i=0; i<stuCount; i++){
            System.out.println("Enter marks of student "+ (i+1) +": ");
            marksList[i] = scanner.nextInt();
        }

//        for (int i=0; i<marksList.length; i++){
//            System.out.println("Marks of student "+ (i+1) +" :"+ marksList[i]);
//        }

        totalMarkList[0] = marksList;
        for(int i=1; i<stuCount; i++){
            for (int j=1; j<3; j++){
                System.out.print("Enter marks for subject"+ (j+1) +": ");
                totalMarkList[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        System.out.println("____________________________________________________________________________________________\n\n");

        System.out.println("\t┌-----------┬-----------┬-----------┬-----------┐");
        System.out.println("\t|\s\sRoll no\t|\tMaths\t|\s\sScience\t|\s\sSocial\t|");
        System.out.println("\t├-----------┼-----------┼-----------┼-----------┤");
        for (int i=0; i<stuCount; i++){
            System.out.print("\t|\t\s\s"+ (i+1) +"\t\t|");
            for (int j=0; j<3; j++){
                System.out.print("\t\s\s" +totalMarkList[i][j]+ " \t|");
            }
            System.out.print("\n");
        }
        System.out.println("\t└-----------┴-----------┴-----------┴-----------┘");

        scanner.close();
    }
}
