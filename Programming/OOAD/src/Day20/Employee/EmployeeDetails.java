package Day20.Employee;

public class EmployeeDetails {
    private final String name;
    private final String email;
    private double salary;
    public EmployeeDetails(String name, String email, double salary){
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
}
