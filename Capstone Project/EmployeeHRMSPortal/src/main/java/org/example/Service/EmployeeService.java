package org.example.Service;

import org.example.DAO.DepartmentDAO;
import org.example.DAO.EmployeeDAO;
import org.example.Model.Department;
import org.example.Model.Employee;

import java.util.UUID;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final DepartmentDAO departmentDAO;

    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
        this.departmentDAO = new DepartmentDAO();
    }

    public void createEmployee(Employee employee, Department department) {
        try {
            // Validate input
            validateEmployee(employee);
            validateDepartment(department);

            // Generate employee ID if not provided
            if (employee.getEmpId() == null || employee.getEmpId().trim().isEmpty()) {
                employee.setEmpId("EMP" + UUID.randomUUID().toString().substring(0, 8));
            }

            // Set the same employee ID for department
            department.setEmpId(employee.getEmpId());

            // Create employee and department records
            employeeDAO.createEmployee(employee);
            departmentDAO.createDepartment(department);

            System.out.println("Employee created successfully with ID: " + employee.getEmpId());
        } catch (Exception e) {
            System.err.println("Error creating employee: " + e.getMessage());
            throw e;
        }
    }

    public Employee getEmployee(String empId) {
        try {
            return employeeDAO.getEmployee(empId);
        } catch (Exception e) {
            System.err.println("Error retrieving employee: " + e.getMessage());
            throw e;
        }
    }

    public void updateEmployee(Employee employee) {
        try {
            validateEmployee(employee);
            employeeDAO.updateEmployee(employee);
            System.out.println("Employee updated successfully");
        } catch (Exception e) {
            System.err.println("Error updating employee: " + e.getMessage());
            throw e;
        }
    }

    public void deleteEmployee(String empId) {
        try {
            employeeDAO.deleteEmployee(empId);
            System.out.println("Employee deleted successfully");
        } catch (Exception e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            throw e;
        }
    }

    private void validateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (employee.getEmpName() == null || employee.getEmpName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name is required");
        }
        if (employee.getMobileNum() == null || !employee.getMobileNum().matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid mobile number");
        }
        if (employee.getEmailId() == null || !employee.getEmailId().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    private void validateDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }
        if (department.getDepartment() == null || department.getDepartment().trim().isEmpty()) {
            throw new IllegalArgumentException("Department name is required");
        }
        if (department.getDesignation() == null || department.getDesignation().trim().isEmpty()) {
            throw new IllegalArgumentException("Designation is required");
        }
        if (department.getDayWage() <= 0) {
            throw new IllegalArgumentException("Day wage must be greater than 0");
        }
    }
}

