import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month num: ");
        int num = scanner.nextInt();

//        if (num == 0) {
//            System.out.println("Entered num is zero.");
//        } else if (num > 0) {
//            System.out.println("Entered num is positive.");
//        } else {
//            System.out.println("Entered num is negative.");
//        }

//        System.out.println();
//        if (num < 60) {
//            System.out.println("Grade F");
//        } else if (num < 70) {
//            System.out.println("Grade D");
//        } else if (num < 80) {
//            System.out.println("Grade C");
//        } else if (num < 90) {
//            System.out.println("Grade B");
//        } else {
//            System.out.println("Grade A");
//        }

        switch (num){
            case 1:
                System.out.println("Jan");
                break;
            case 2:
                System.out.println("Feb");
                break;
            case 3:
                System.out.println("Mar");
                break;
            case 4:
                System.out.println("Apr");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("Jun");
                break;
            case 7:
                System.out.println("Jul");
                break;
            case 8:
                System.out.println("Aug");
                break;
            case 9:
                System.out.println("Sept");
                break;
            case 10:
                System.out.println("Oct");
                break;
            case 11:
                System.out.println("Nov");
                break;
            case 12:
                System.out.println("Dec");
                break;
            default:
                System.out.println("Enter a num between 1 and 12");
        }

        scanner.close();
    }
}
