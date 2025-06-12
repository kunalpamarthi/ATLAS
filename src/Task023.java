// Task023: Illustrate creating an array of objects.

import java.util.Scanner;

class Students{
    public String studentName;
    public int rollNum;
    Students(int rollNum, String studentName){
        this.studentName = studentName;
        this.rollNum = rollNum;
    }
}

public class Task023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter no. of students: ");
        int totalStudents = scanner.nextInt();
        Students[] students = new Students[totalStudents];
        for (int i = 0; i < totalStudents; i++) {
            System.out.print("Roll no: ");
            int roll = scanner.nextInt();
            System.out.print("Name: ");
            String name = scanner.next();
            students[i] = new Students(roll, name);
        }
        int roll = 1;
        while (roll <= totalStudents){
            System.out.print("\nEnter roll number: ");
            roll = scanner.nextInt();
            System.out.println(students[roll-1].rollNum +
                    "\t"+ students[roll-1].studentName);
        }
        scanner.close();
    }
}
