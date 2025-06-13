// Task014: Return the outer class variable.

package Collections;

class Department{
    String deptName;
    Department(String name){
        this.deptName = name;
    }
    class Batch{
        void display(){
            System.out.println(deptName);
        }
    }
}

public class Task014 {
    public static void main(String[] args) {
        String deptName = "SHIELD";
        Department department = new Department(deptName);
        Department.Batch batch = department.new Batch();
        batch.display();
    }
}
