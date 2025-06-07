class Student{
   public String name;
   public String mobile;
    Student(String name, String mobile){
       this.name = name;
       this.mobile = mobile;
   }

    @Override
    public String toString() {
        return name+" "+mobile;
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] myStudents = new Student[]{
                new Student("Dharma", "123"), new Student("Sanvi", "456"),
                new Student("Rupa", "345"), new Student("Ajay", "789")
        };
        // accessing the elements of the specified array
        for (Student m : myStudents) {
            System.out.println(m);
        }
    }
}