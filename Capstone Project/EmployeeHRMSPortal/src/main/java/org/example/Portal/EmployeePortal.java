package org.example.Portal;

import org.example.Model.Attendance;
import org.example.Model.Department;
import org.example.Model.Employee;
import org.example.Model.Salary;
import org.example.Service.AttendanceService;
import org.example.Service.DepartmentService;
import org.example.Service.EmployeeService;
import org.example.Service.PayrollService;

import java.util.Scanner;
import java.util.List;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class EmployeePortal {
    private final String empId;
    private final Scanner scanner;
    private final EmployeeService employeeService;
    private final AttendanceService attendanceService;
    private final DepartmentService departmentService;
    private final PayrollService payrollService;

    public EmployeePortal(String empId) {
        this.empId = empId;
        this.scanner = new Scanner(System.in);
        this.employeeService = new EmployeeService();
        this.attendanceService = new AttendanceService();
        this.departmentService = new DepartmentService();
        this.payrollService = new PayrollService();
    }

    public void start() {
        while (true) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        viewProfile();
                        break;
                    case 2:
                        updateProfile();
                        break;
                    case 3:
                        viewAttendance();
                        break;
                    case 4:
                        applyLeave();
                        break;
                    case 5:
                        viewPayslip();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n========== Employee Portal ==========");
        System.out.println("1. View Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. View Attendance");
        System.out.println("4. Apply Leave");
        System.out.println("5. View Payslip");
        System.out.println("6. Logout");
        System.out.println("====================================");
        System.out.print("Enter your choice: ");
    }

    private void viewProfile() {
        System.out.println("\n---------- Employee Profile ----------");
        try {
            Employee employee = employeeService.getEmployee(empId);
            Department department = departmentService.getEmployeeDepartment(empId);

            System.out.println("Employee ID: " + employee.getEmpId());
            System.out.println("Name: " + employee.getEmpName());
            System.out.println("Mobile: " + employee.getMobileNum());
            System.out.println("Email: " + employee.getEmailId());
            System.out.println("Department: " + department.getDepartment());
            System.out.println("Designation: " + department.getDesignation());
        } catch (Exception e) {
            System.out.println("Error retrieving profile: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void updateProfile() {
        System.out.println("\n---------- Update Profile ----------");
        try {
            Employee employee = employeeService.getEmployee(empId);

            System.out.print("Enter new mobile number (or press Enter to skip): ");
            String mobile = scanner.nextLine();
            if (!mobile.isEmpty()) {
                employee.setMobileNum(mobile);
            }

            System.out.print("Enter new email (or press Enter to skip): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                employee.setEmailId(email);
            }

            employeeService.updateEmployee(employee);
            System.out.println("Profile updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating profile: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void viewAttendance() {
        System.out.println("\n---------- Attendance Record ----------");
        try {
            String yearMonth = YearMonth.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
            List<Attendance> attendanceList = attendanceService.getMonthlyAttendance(empId, yearMonth);

            if (attendanceList.isEmpty()) {
                System.out.println("No attendance records found for this month.");
            } else {
                attendanceList.forEach(attendance ->
                        System.out.println(attendance.getDate() + ": " +
                                (attendance.getAttendanceValue() == 1.0 ? "Full Day" :
                                        attendance.getAttendanceValue() == 0.5 ? "Half Day" : "Absent"))
                );
            }
        } catch (Exception e) {
            System.out.println("Error retrieving attendance: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void applyLeave() {
        System.out.println("\n---------- Apply Leave ----------");
        try {
            System.out.print("Enter start date (YYYY-MM-DD): ");
            String startDate = scanner.nextLine();

            System.out.print("Enter end date (YYYY-MM-DD): ");
            String endDate = scanner.nextLine();

            System.out.print("Enter reason for leave: ");
            String reason = scanner.nextLine();

            attendanceService.submitLeaveRequest(empId, startDate, endDate, reason);
            System.out.println("Leave request submitted successfully!");
        } catch (Exception e) {
            System.out.println("Error submitting leave request: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void viewPayslip() {
        System.out.println("\n---------- Payslip ----------");
        try {
            System.out.print("Enter month (YYYY-MM): ");
            String yearMonth = scanner.nextLine();

            Salary salary = payrollService.getSalarySlip(empId, yearMonth);
            if (salary != null) {
                System.out.println("Basic: ₹" + salary.getBasic());
                System.out.println("HRA: ₹" + salary.getHra());
                System.out.println("PF Contribution: ₹" + salary.getPfContribution());
                System.out.println("Net Pay: ₹" + salary.getNetPay());
            } else {
                System.out.println("No salary record found for the specified month.");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving payslip: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
