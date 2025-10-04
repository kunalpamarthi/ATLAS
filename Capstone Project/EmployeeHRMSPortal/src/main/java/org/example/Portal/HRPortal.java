package org.example.Portal;

import org.example.Model.*;
import org.example.Service.*;

import java.util.List;
import java.util.Scanner;

public class HRPortal {
    private final Scanner scanner;
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final AttendanceService attendanceService;
    private final PayrollService payrollService;

    public HRPortal() {
        this.scanner = new Scanner(System.in);
        this.employeeService = new EmployeeService();
        this.departmentService = new DepartmentService();
        this.attendanceService = new AttendanceService();
        this.payrollService = new PayrollService();
    }

    public void start() {
        while (true) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        manageEmployees();
                        break;
                    case 2:
                        manageDepartments();
                        break;
                    case 3:
                        manageAttendance();
                        break;
                    case 4:
                        manageLeaves();
                        break;
                    case 5:
                        managePayroll();
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
        System.out.println("\n============ HR Portal ============");
        System.out.println("1. Manage Employees");
        System.out.println("2. Manage Departments");
        System.out.println("3. Manage Attendance");
        System.out.println("4. Manage Leave Requests");
        System.out.println("5. Manage Payroll");
        System.out.println("6. Logout");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }

    private void manageEmployees() {
        while (true) {
            System.out.println("\n------ Employee Management ------");
            System.out.println("1. Add New Employee");
            System.out.println("2. View Employee Details");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        addNewEmployee();
                        break;
                    case 2:
                        viewEmployeeDetails();
                        break;
                    case 3:
                        updateEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void manageDepartments() {
        while (true) {
            System.out.println("\n------ Department Management ------");
            System.out.println("1. Assign Department to Employee");
            System.out.println("2. Update Employee Designation");
            System.out.println("3. Update Day Wage");
            System.out.println("4. View Department Details");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        assignDepartment();
                        break;
                    case 2:
                        updateDesignation();
                        break;
                    case 3:
                        updateDayWage();
                        break;
                    case 4:
                        viewDepartmentDetails();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void manageAttendance() {
        while (true) {
            System.out.println("\n------ Attendance Management ------");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Employee Attendance");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        markAttendance();
                        break;
                    case 2:
                        viewEmployeeAttendance();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void manageLeaves() {
        while (true) {
            System.out.println("\n------ Leave Management ------");
            System.out.println("1. View Pending Leave Requests");
            System.out.println("2. Approve/Reject Leave Request");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        viewPendingLeaveRequests();
                        break;
                    case 2:
                        processLeaveRequest();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void managePayroll() {
        while (true) {
            System.out.println("\n------ Payroll Management ------");
            System.out.println("1. Process Monthly Payroll");
            System.out.println("2. View Employee Salary Details");
//            System.out.println("3. Generate Salary Slips");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        processMonthlyPayroll();
                        break;
                    case 2:
                        viewSalaryDetails();
                        break;
//                    case 3:
//                        generateSalarySlips();
//                        break;
                    case 3:
                        payrollService.shutdown();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Implementation of individual operations...
    private void addNewEmployee() {
        System.out.println("\n--- Add New Employee ---");
        try {
            Employee employee = new Employee();

            System.out.print("Enter Employee Name: ");
            employee.setEmpName(scanner.nextLine());

            System.out.print("Enter Mobile Number: ");
            employee.setMobileNum(scanner.nextLine());

            System.out.print("Enter Email ID: ");
            employee.setEmailId(scanner.nextLine());

            Department department = new Department();
            System.out.print("Enter Department: ");
            department.setDepartment(scanner.nextLine());

            System.out.print("Enter Designation: ");
            department.setDesignation(scanner.nextLine());

            System.out.print("Enter Day Wage: ");
            department.setDayWage(Double.parseDouble(scanner.nextLine()));

            employeeService.createEmployee(employee, department);
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void processMonthlyPayroll() {
        System.out.println("\n--- Process Monthly Payroll ---");
        try {
            payrollService.initiateMonthlyPayrollBatch();
            System.out.println("Monthly payroll processing initiated!");
        } catch (Exception e) {
            System.out.println("Error processing payroll: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    // Continuing in HRPortal.java
// Add these methods to the existing class

    private void viewEmployeeDetails() {
        System.out.println("\n--- View Employee Details ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            Employee employee = employeeService.getEmployee(empId);
            Department department = departmentService.getEmployeeDepartment(empId);

            if (employee != null) {
                System.out.println("\nEmployee Details:");
                System.out.println("ID: " + employee.getEmpId());
                System.out.println("Name: " + employee.getEmpName());
                System.out.println("Mobile: " + employee.getMobileNum());
                System.out.println("Email: " + employee.getEmailId());
                System.out.println("Department: " + department.getDepartment());
                System.out.println("Designation: " + department.getDesignation());
                System.out.println("Day Wage: ₹" + department.getDayWage());
            } else {
                System.out.println("Employee not found!");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving employee details: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void updateEmployee() {
        System.out.println("\n--- Update Employee Details ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            Employee employee = employeeService.getEmployee(empId);
            if (employee == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.println("Current Details:");
            System.out.println("Name: " + employee.getEmpName());
            System.out.println("Mobile: " + employee.getMobileNum());
            System.out.println("Email: " + employee.getEmailId());

            System.out.print("\nEnter new name (or press Enter to skip): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                employee.setEmpName(name);
            }

            System.out.print("Enter new mobile (or press Enter to skip): ");
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
            System.out.println("Employee details updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Are you sure you want to delete this employee? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                employeeService.deleteEmployee(empId);
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void assignDepartment() {
        System.out.println("\n--- Assign Department ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            Department department = new Department();
            department.setEmpId(empId);

            System.out.print("Enter Department Name: ");
            department.setDepartment(scanner.nextLine());

            System.out.print("Enter Designation: ");
            department.setDesignation(scanner.nextLine());

            System.out.print("Enter Day Wage: ");
            department.setDayWage(Double.parseDouble(scanner.nextLine()));

            departmentService.assignDepartment(empId, department);
            System.out.println("Department assigned successfully!");
        } catch (Exception e) {
            System.out.println("Error assigning department: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void updateDesignation() {
        System.out.println("\n--- Update Designation ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Enter New Designation: ");
            String newDesignation = scanner.nextLine();

            System.out.print("Enter New Day Wage: ");
            double newDayWage = Double.parseDouble(scanner.nextLine());

            departmentService.updateEmployeeDesignation(empId, newDesignation, newDayWage);
            System.out.println("Designation updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating designation: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void updateDayWage() {
        System.out.println("\n--- Update Day Wage ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Enter New Day Wage: ");
            double newDayWage = Double.parseDouble(scanner.nextLine());

            departmentService.updateDayWage(empId, newDayWage);
            System.out.println("Day wage updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating day wage: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void viewDepartmentDetails() {
        System.out.println("\n--- View Department Details ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            Department department = departmentService.getEmployeeDepartment(empId);
            if (department != null) {
                System.out.println("\nDepartment Details:");
                System.out.println("Department: " + department.getDepartment());
                System.out.println("Designation: " + department.getDesignation());
                System.out.println("Day Wage: ₹" + department.getDayWage());
            } else {
                System.out.println("Department details not found!");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving department details: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void markAttendance() {
        System.out.println("\n--- Mark Attendance ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.println("Enter Attendance Value:");
            System.out.println("1.0 - Full Day");
            System.out.println("0.5 - Half Day");
            System.out.println("0.0 - Absent");
            System.out.print("Enter value: ");
            double attendanceValue = Double.parseDouble(scanner.nextLine());

            attendanceService.markAttendance(empId, attendanceValue);
            System.out.println("Attendance marked successfully!");
        } catch (Exception e) {
            System.out.println("Error marking attendance: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void viewEmployeeAttendance() {
        System.out.println("\n--- View Employee Attendance ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Enter Month (YYYY-MM): ");
            String yearMonth = scanner.nextLine();

            List<Attendance> attendanceList = attendanceService.getMonthlyAttendance(empId, yearMonth);
            if (!attendanceList.isEmpty()) {
                System.out.println("\nAttendance Records:");
                attendanceList.forEach(attendance ->
                        System.out.println(attendance.getDate() + ": " +
                                (attendance.getAttendanceValue() == 1.0 ? "Full Day" :
                                        attendance.getAttendanceValue() == 0.5 ? "Half Day" : "Absent"))
                );
            } else {
                System.out.println("No attendance records found!");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving attendance: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void viewPendingLeaveRequests() {
        System.out.println("\n--- Pending Leave Requests ---");
        try {
            // This method would need to be added to AttendanceService
            List<LeaveRequest> pendingRequests = attendanceService.getPendingLeaveRequests();
            if (!pendingRequests.isEmpty()) {
                pendingRequests.forEach(request -> {
                    System.out.println("\nRequest ID: " + request.getRequestId());
                    System.out.println("Employee ID: " + request.getEmpId());
                    System.out.println("From: " + request.getStartDate());
                    System.out.println("To: " + request.getEndDate());
                    System.out.println("Reason: " + request.getReason());
                    System.out.println("----------------");
                });
            } else {
                System.out.println("No pending leave requests!");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving leave requests: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void processLeaveRequest() {
        System.out.println("\n--- Process Leave Request ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Enter Request ID: ");
            String requestId = scanner.nextLine();

            System.out.print("Enter Decision (APPROVED/REJECTED): ");
            String status = scanner.nextLine().toUpperCase();

            attendanceService.updateLeaveRequestStatus(empId, requestId, status);
            System.out.println("Leave request processed successfully!");
        } catch (Exception e) {
            System.out.println("Error processing leave request: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void viewSalaryDetails() {
        System.out.println("\n--- View Salary Details ---");
        try {
            System.out.print("Enter Employee ID: ");
            String empId = scanner.nextLine();

            System.out.print("Enter Month (YYYY-MM): ");
            String month = scanner.nextLine();

            Salary salary = payrollService.getSalarySlip(empId, month);
            if (salary != null) {
                System.out.println("\nSalary Details:");
                System.out.println("Basic: ₹" + salary.getBasic());
                System.out.println("HRA: ₹" + salary.getHra());
                System.out.println("PF Contribution: ₹" + salary.getPfContribution());
                System.out.println("Net Pay: ₹" + salary.getNetPay());
            } else {
                System.out.println("Salary details not found!");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving salary details: " + e.getMessage());
        }
        pressEnterToContinue();
    }

    private void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }


}
