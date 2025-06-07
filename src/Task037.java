// Encapsulation: Access modifiers.

class Employee{
    public int empID;
    protected String empName;
    private int salary;

    Employee(int empID, String empName, int salary){
        this.salary = salary;
        this.empName = empName;
        this.empID = empID;
    }
}

class HR extends Employee{

    HR(int empID, String empName, int salary) {
        super(empID, empName, salary);
    }

    void display(){
        System.out.println(empID +" "+ empName);
    }
}

public class Task037 {
    public static void main(String[] args) {
        HR emp1 = new HR(123, "adc", 90000);
        emp1.display();
    }
}
