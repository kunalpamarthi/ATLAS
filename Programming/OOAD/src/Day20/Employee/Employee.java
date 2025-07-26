// Task004: SRP Implementation

package Day20.Employee;

public class Employee {
    public static void main(String[] args) {
        EmployeeDetails employeeDetails = new EmployeeDetails("kunal", "kuna@shiro", 25000);
        ReportGenerator reportGenerator = new ReportGenerator();
        employeeDetails.setSalary(50000);
        reportGenerator.generateReport(employeeDetails);
    }
}
