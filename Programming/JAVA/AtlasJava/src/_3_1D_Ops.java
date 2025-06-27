import java.util.Scanner;

public class _3_1D_Ops {

    public static double avgGrades(int[] gradeList){
        double avg, sum=0;
        for (int j : gradeList) {
            sum += j;
        }
        avg = sum/gradeList.length;
        return avg;
    }

    public static int[] minMax(int[] gradeList){
        int[] ends = {gradeList[0], gradeList[0]};
        for(int i: gradeList){
/*
            ends[0] = (i<ends[0]) ? i : ends[0];
            ends[1] = (i>ends[1]) ? i : ends[1];
*/
            ends[0] = Math.min(i, ends[0]);
            ends[1] = Math.max(i, ends[1]);
        }

        return ends;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no. of students: ");
        int stuCount = scanner.nextInt();
        int[] gradeList = new int[stuCount];
        for (int i=0; i<stuCount; i++){
            System.out.print("Enter student "+ (i+1) +" marks: ");
            gradeList[i] = scanner.nextInt();
        }
        double avg = avgGrades(gradeList);
        int max = minMax(gradeList)[1], min = minMax(gradeList)[0];
        System.out.println("Minimum grade: "+ min +"\nMaximum grade: " + max);
        System.out.println("\nAverage of the grades: "+avg);
        scanner.close();
    }
}
