package org.example.Portal;

import org.example.Service.EmployeeService;

import java.util.Scanner;

public class MainPortal {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        System.out.println("\n=== Welcome to Employee HRMS ===");

        while (true) {
            try {
                displayMainMenu();
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        handleEmployeeLogin();
                        break;
                    case 2:
                        handleHRLogin();
                        break;
                    case 3:
                        System.out.println("\nThank you for using HRMS. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== HRMS Main Menu ===");
        System.out.println("1. Employee Login");
        System.out.println("2. HR Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleEmployeeLogin() {
        System.out.println("\n=== Employee Login ===");
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine().trim();

        try {
            if (employeeService.getEmployee(empId) != null) {
                System.out.println("Login successful!");
                EmployeePortal employeePortal = new EmployeePortal(empId);
                employeePortal.start();
            } else {
                System.out.println("Invalid Employee ID!");
            }
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }

    private static void handleHRLogin() {
        System.out.println("\n=== HR Login ===");
        System.out.print("Enter HR ID: ");
        String hrId = scanner.nextLine().trim();

        if ("HR001".equals(hrId)) {  // Simplified validation
            System.out.println("Login successful!");
            HRPortal hrPortal = new HRPortal();
            hrPortal.start();
        } else {
            System.out.println("Invalid HR ID!");
        }
    }
}
