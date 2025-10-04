package org.example.Service;

import org.example.DAO.DepartmentDAO;
import org.example.DAO.EmployeeDAO;
import org.example.Model.Department;
import org.example.Model.Employee;


public class DepartmentService {
    private final DepartmentDAO departmentDAO;
    private final EmployeeDAO employeeDAO;

    public DepartmentService() {
        this.departmentDAO = new DepartmentDAO();
        this.employeeDAO = new EmployeeDAO();
    }

    public void assignDepartment(String empId, Department department) {
        try {
            // Validate employee exists
            Employee employee = employeeDAO.getEmployee(empId);
            if (employee == null) {
                throw new IllegalArgumentException("Employee not found");
            }

            // Validate department details
            validateDepartment(department);

            // Set employee ID and create/update department record
            department.setEmpId(empId);
            departmentDAO.createDepartment(department);
            System.out.println("Department assigned successfully to employee: " + empId);

        } catch (Exception e) {
            System.err.println("Error assigning department: " + e.getMessage());
            throw e;
        }
    }

    public void updateEmployeeDesignation(String empId, String newDesignation, double newDayWage) {
        try {
            // Get existing department details
            Department department = departmentDAO.getDepartment(empId);
            if (department == null) {
                throw new IllegalArgumentException("Department record not found for employee");
            }

            // Update designation and wage
            department.setDesignation(newDesignation);
            department.setDayWage(newDayWage);

            // Save updates
            departmentDAO.createDepartment(department); // Using create as update
            System.out.println("Designation updated successfully for employee: " + empId);

        } catch (Exception e) {
            System.err.println("Error updating designation: " + e.getMessage());
            throw e;
        }
    }

    public Department getEmployeeDepartment(String empId) {
        try {
            Department department = departmentDAO.getDepartment(empId);
            if (department == null) {
                throw new IllegalArgumentException("Department record not found for employee");
            }
            return department;
        } catch (Exception e) {
            System.err.println("Error retrieving department details: " + e.getMessage());
            throw e;
        }
    }

    public void updateDayWage(String empId, double newDayWage) {
        try {
            // Validate wage
            if (newDayWage <= 0) {
                throw new IllegalArgumentException("Day wage must be greater than 0");
            }

            // Get existing department details
            Department department = departmentDAO.getDepartment(empId);
            if (department == null) {
                throw new IllegalArgumentException("Department record not found for employee");
            }

            // Update wage
            department.setDayWage(newDayWage);

            // Save updates
            departmentDAO.createDepartment(department);
            System.out.println("Day wage updated successfully for employee: " + empId);

        } catch (Exception e) {
            System.err.println("Error updating day wage: " + e.getMessage());
            throw e;
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
