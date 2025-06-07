class Student{
   public String name;
   public int mobile;
    Student(String name, int mobile){
       this.name = name;
       this.mobile = mobile;
   }

   @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] myStudents = new Student[]{
                new Student("Dharma", 123), new Student("Sanvi", 789),
                new Student("Rupa", 345), new Student("Ajay", 3456)
        };
        // accessing the elements of the specified array
        for (Student m : myStudents) {
            System.out.println(m);
        }
    }
}