package Day20.Employee;

import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {
    public void generateReport(EmployeeDetails employeeDetails){
        String name = employeeDetails.getName();
        String email = employeeDetails.getEmail();
        double salary = employeeDetails.getSalary();

        try(FileWriter fileWriter = new FileWriter(email+".txt")){
            fileWriter.write("Employee name: "+name+".\n");
            fileWriter.write("Employee email: "+email+".\n");
            fileWriter.write("Employee salary: "+salary+".\n");
//            System.out.println("Report generated successfully for "+name);
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(name, "Report generated successfully for you with name: "+email+".pdf");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
