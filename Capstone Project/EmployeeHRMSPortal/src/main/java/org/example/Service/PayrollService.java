package org.example.Service;

import org.example.DAO.AttendanceDAO;
import org.example.DAO.DepartmentDAO;
import org.example.DAO.EmployeeDAO;
import org.example.DAO.SalaryDAO;
import org.example.Model.Attendance;
import org.example.Model.Department;
import org.example.Model.Employee;
import org.example.Model.Salary;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PayrollService {
    private final SalaryDAO salaryDAO;
    private final EmployeeDAO employeeDAO;
    private final DepartmentDAO departmentDAO;
    private final AttendanceDAO attendanceDAO;
    private final Queue<String> payrollQueue;
    private final ExecutorService executorService;

    public PayrollService() {
        this.salaryDAO = new SalaryDAO();
        this.employeeDAO = new EmployeeDAO();
        this.departmentDAO = new DepartmentDAO();
        this.attendanceDAO = new AttendanceDAO();
        this.payrollQueue = new ConcurrentLinkedQueue<>();
        this.executorService = Executors.newFixedThreadPool(5); // 5 threads for parallel processing
    }

    // Add employee to payroll processing queue
    public void queueEmployeeForPayroll(String empId) {
        payrollQueue.offer(empId);
    }

    // Process monthly payroll for all queued employees
    public void processMonthlyPayroll(String yearMonth) {
        System.out.println("Starting monthly payroll processing for " + yearMonth);

        try {
            while (!payrollQueue.isEmpty()) {
                String empId = payrollQueue.poll();
                if (empId != null) {
                    executorService.submit(() -> processEmployeePayroll(empId, yearMonth));
                }
            }

            // Shutdown executor and wait for completion
            executorService.shutdown();
            //noinspection ResultOfMethodCallIgnored
            executorService.awaitTermination(30, TimeUnit.MINUTES);

            System.out.println("Monthly payroll processing completed for " + yearMonth);
        } catch (Exception e) {
            System.err.println("Error processing monthly payroll: " + e.getMessage());
            throw new RuntimeException("Payroll processing failed", e);
        }
    }

    // Process individual employee payroll
    private void processEmployeePayroll(String empId, String yearMonth) {
        try {
            Employee employee = employeeDAO.getEmployee(empId);
            Department department = departmentDAO.getDepartment(empId);
            List<Attendance> monthlyAttendance = attendanceDAO.getMonthlyAttendance(empId, yearMonth);

            if (employee == null || department == null) {
                System.err.println("Missing employee or department data for ID: " + empId);
                return;
            }

            // Calculate salary components
            Salary salary = calculateSalary(department, monthlyAttendance, yearMonth);
            salary.setEmpId(empId);
            salary.setMonth(yearMonth);

            // Save salary record
            salaryDAO.createSalary(salary);
            System.out.println("Processed payroll for employee: " + empId);

        } catch (Exception e) {
            System.err.println("Error processing payroll for employee " + empId + ": " + e.getMessage());
        }
    }

    private Salary calculateSalary(Department department, List<Attendance> monthlyAttendance, String yearMonth) {
        double dayWage = department.getDayWage();
        YearMonth ym = YearMonth.parse(yearMonth);
        int totalWorkingDays = ym.lengthOfMonth(); // Assuming all days are working days

        // Calculate attendance
        double totalDaysPresent = totalWorkingDays - monthlyAttendance.stream()
                .mapToDouble(Attendance::getAttendanceValue)
                .sum();

        // Calculate basic salary based on attendance
        double basicSalary = dayWage * totalDaysPresent;

        // Calculate other components
        double hra = basicSalary * 0.4; // 40% of basic as HRA
        double pfContribution = basicSalary * 0.12; // 12% of basic as PF
        double netPay = basicSalary + hra - pfContribution;
        Salary salary = new Salary();
        salary.setBasic(basicSalary);
        salary.setHra(hra);
        salary.setPfContribution(pfContribution);
        salary.setNetPay(netPay);
        return salary;
    }

    // Get salary slip for an employee
    public Salary getSalarySlip(String empId, String yearMonth) {
        try {
            return salaryDAO.getSalary(empId, yearMonth);
        } catch (Exception e) {
            System.err.println("Error retrieving salary slip: " + e.getMessage());
            throw e;
        }
    }

    // Batch processing for all employees
    public void initiateMonthlyPayrollBatch() {
        String currentMonth = YearMonth.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("Initiating batch payroll processing for " + currentMonth);

        try {
            List<Employee> activeEmployees = employeeDAO.getAllActiveEmployees();
            System.out.println("Processing payroll for "+ activeEmployees.size() +" employees.");
            activeEmployees.forEach(emp -> queueEmployeeForPayroll(emp.getEmpId()));
            processMonthlyPayroll(currentMonth);
        } catch (Exception e) {
            System.err.println("Error in payroll batch processing: " + e.getMessage());
            throw new RuntimeException("Batch processing failed", e);
        }
    }

    public void shutdown() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdownNow();
        }
    }
}
