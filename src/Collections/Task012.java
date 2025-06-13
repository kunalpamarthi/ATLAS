// Task011: Nested classes.

package Collections;

class University{
    private final String name;

    public University(String name) {
        this.name = name;
    }

    private class Department {
        private final String departmentName;

        public Department(String departmentName) {
            this.departmentName = departmentName;
        }

        public void printInfo() {
            System.out.println("University: " + University.this.name);
            System.out.println("Department: " + departmentName);
        }
    }

    public void createDepartment(String departmentName) {
        Department department = new Department(departmentName);
        department.printInfo();
    }
}

public class Task012 {
    public static void main(String[] args) {
        String uni = "IIIT Kottayam";
        String dept = "CSE";
        University university = new University(uni);
        university.createDepartment(dept);
    }
}
