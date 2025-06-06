//Task11: WAP to check if  week days. Switch case.

import java.util.Scanner;

public class Task011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day number: ");
        int day = scanner.nextInt();
        week_day(day);
        System.out.print("Enter day number: ");
        int day1 = scanner.nextInt();
        week_day(day1);
        System.out.print("Enter day number: ");
        int day2 = scanner.nextInt();
        week_day(day2);
        System.out.print("Enter day number: ");
        int day3 = scanner.nextInt();
        week_day(day3);
        scanner.close();
    }

    private static void week_day(int day) {
        switch(day){
            case 1:
                System.out.println("Day "+day+
                        " of the week is Sunday.");
                return;
            case 2:
                System.out.println("Day "+day+
                        " of the week is Monday.");
                return;
            case 3:
                System.out.println("Day "+day+
                        " of the week is Tuesday.");
                return;
            case 4:
                System.out.println("Day "+day+
                        " of the week is Wednesday.");
                return;
            case 5:
                System.out.println("Day "+day+
                        " of the week is Thursday.");
                return;
            case 6:
                System.out.println("Day "+day+
                        " of the week is Friday.");
                return;
            case 7:
                System.out.println("Day "+day+
                        " of the week is Saturday.");
                return;
            default: System.out.println(
                    "Day number must be within the range of 1-7.");
        }
    }
}
