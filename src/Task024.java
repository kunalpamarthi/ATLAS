// Task024: Another way of creating array of objects.

public class Task024 {
    public static void main(String[] args) {
        Students[] students = new Students[]{
                new Students(21, "Kris"),
                new Students(31, "Sindhu"),
                new Students(32, "Nirupama"),
                new Students(72, "Sumana")
        };
        for (Students stud: students){
            System.out.println(stud.rollNum+"\t"+stud.studentName);
        }
    }
}
