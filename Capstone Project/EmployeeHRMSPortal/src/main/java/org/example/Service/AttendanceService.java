package org.example.Service;

import org.example.Config.Constants;
import org.example.DAO.*;
import org.example.Model.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AttendanceService {
    private final AttendanceDAO attendanceDAO;
    private final EmployeeDAO employeeDAO;
    private final LeaveRequestDAO leaveRequestDAO;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public AttendanceService() {
        this.attendanceDAO = new AttendanceDAO();
        this.employeeDAO = new EmployeeDAO();
        this.leaveRequestDAO = new LeaveRequestDAO();
    }

    public void markAttendance(String empId, double attendanceValue) {
        try {
            validateAttendanceValue(attendanceValue);

            Attendance attendance = new Attendance();
            attendance.setEmpId(empId);
            attendance.setDate(LocalDate.now().format(DATE_FORMATTER));
            attendance.setAttendanceValue(attendanceValue);

            attendanceDAO.markAttendance(attendance);
            System.out.println("Attendance marked successfully");
        } catch (Exception e) {
            System.err.println("Error marking attendance: " + e.getMessage());
            throw e;
        }
    }

    public List<Attendance> getMonthlyAttendance(String empId, String yearMonth) {
        try {
            return attendanceDAO.getMonthlyAttendance(empId, yearMonth);
        } catch (Exception e) {
            System.err.println("Error retrieving monthly attendance: " + e.getMessage());
            throw e;
        }
    }

    public void submitLeaveRequest(String empId, String startDate, String endDate, String reason) {
        try {
            validateDates(startDate, endDate);

            LeaveRequest leaveRequest = new LeaveRequest();
            leaveRequest.setEmpId(empId);
            leaveRequest.setRequestId("LR" + UUID.randomUUID().toString().substring(0, 8));
            leaveRequest.setStartDate(startDate);
            leaveRequest.setEndDate(endDate);
            leaveRequest.setReason(reason);
            leaveRequest.setStatus("PENDING");

            leaveRequestDAO.createLeaveRequest(leaveRequest);
            System.out.println("Leave request submitted successfully");
        } catch (Exception e) {
            System.err.println("Error submitting leave request: " + e.getMessage());
            throw e;
        }
    }

    public List<LeaveRequest> getEmployeeLeaveRequests(String empId) {
        try {
            return leaveRequestDAO.getEmployeeLeaveRequests(empId);
        } catch (Exception e) {
            System.err.println("Error retrieving leave requests: " + e.getMessage());
            throw e;
        }
    }

    private void validateAttendanceValue(double attendanceValue) {
        if (attendanceValue != Constants.ABSENT && attendanceValue != Constants.HALF_DAY && attendanceValue != Constants.FULL_DAY) {
            throw new IllegalArgumentException("Invalid attendance value. Must be 0.0, 0.5, or 1.0");
        }
    }

    private void validateDates(String startDate, String endDate) {
        try {
            LocalDate start = LocalDate.parse(startDate, DATE_FORMATTER);
            LocalDate end = LocalDate.parse(endDate, DATE_FORMATTER);
            long workingDays = calculateWorkingDays(start, end);

            if (workingDays > 30) {
                throw new IllegalArgumentException("Leave cannot exceed 30 working days");
            }
            if (start.isAfter(end)) {
                throw new IllegalArgumentException("Start date cannot be after end date");
            }
            if (start.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Cannot apply leave for past dates");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Use yyyy-MM-dd");
        }
    }

    public List<LeaveRequest> getPendingLeaveRequests() {
        try {
            // Get all active employees
            List<Employee> activeEmployees = employeeDAO.getAllActiveEmployees();
            List<LeaveRequest> pendingRequests = new ArrayList<>();

            // Get pending leave requests for each employee
            for (Employee employee : activeEmployees) {
                List<LeaveRequest> employeeRequests = getEmployeeLeaveRequests(employee.getEmpId());
                // Filter for pending requests
                employeeRequests.stream()
                        .filter(request -> "PENDING".equals(request.getStatus()))
                        .forEach(pendingRequests::add);
            }

//            // Sort by applied date (most recent first)
//            pendingRequests.sort((r1, r2) ->
//                    LocalDate.parse(r2.getAppliedDate()).compareTo(LocalDate.parse(r1.getAppliedDate())));

            return pendingRequests;
        } catch (Exception e) {
            System.err.println("Error retrieving pending leave requests: " + e.getMessage());
            throw e;
        }
    }

    public void updateLeaveRequestStatus(String empId, String requestId, String status) {
        try {
            // Validate inputs
            if (empId == null || empId.trim().isEmpty()) {
                throw new IllegalArgumentException("Employee ID cannot be empty");
            }
            if (requestId == null || requestId.trim().isEmpty()) {
                throw new IllegalArgumentException("Request ID cannot be empty");
            }
            if (status == null || status.trim().isEmpty()) {
                throw new IllegalArgumentException("Status cannot be empty");
            }

            // Validate status value
            status = status.toUpperCase();
            if (!status.matches("APPROVED|REJECTED")) {
                throw new IllegalArgumentException("Invalid status. Must be either APPROVED or REJECTED");
            }

            // Get the leave request
            LeaveRequest leaveRequest = leaveRequestDAO.getLeaveRequest(empId, requestId);
            if (leaveRequest == null) {
                throw new IllegalArgumentException("Leave request not found");
            }

            // Check if request is already processed
            if (!Constants.PENDING.equals(leaveRequest.getStatus())) {
                throw new IllegalStateException("Leave request is already " + leaveRequest.getStatus());
            }

            // Update the status
            leaveRequestDAO.updateLeaveRequestStatus(empId, requestId, status);

            // If approved, mark the leave days in attendance
            if (Constants.APPROVED.equals(status)) {
                markLeaveInAttendance(leaveRequest);
            }

            System.out.println("Leave request " + status.toLowerCase() + " successfully");

            // Log the action (you can implement a separate logging mechanism)
//            logLeaveAction(empId, requestId, status);

        } catch (Exception e) {
            System.err.println("Error updating leave request status: " + e.getMessage());
            throw e;
        }
    }

    private void markLeaveInAttendance(LeaveRequest leaveRequest) {
        try {
            LocalDate startDate = LocalDate.parse(leaveRequest.getStartDate());
            LocalDate endDate = LocalDate.parse(leaveRequest.getEndDate());

            // Iterate through each day of the leave period
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                // Skip weekends (assuming Saturday and Sunday are weekends)
                if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                        date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    continue;
                }

                // Create attendance record for the leave day
                Attendance attendance = new Attendance();
                attendance.setEmpId(leaveRequest.getEmpId());
                attendance.setDate(date.toString());
                attendance.setAttendanceValue(0.0); // Marked as absent due to approved leave

                // Save attendance record
                attendanceDAO.markAttendance(attendance);
            }

        } catch (Exception e) {
            System.err.println("Error marking leave in attendance: " + e.getMessage());
            throw e;
        }
    }

//    private void logLeaveAction(String empId, String requestId, String status) {
//        try {
//            // Create logs directory if it doesn't exist
//            File logsDir = new File("logs");
//            if (!logsDir.exists()) {
//                logsDir.mkdirs();
//            }
//
//            // Create or append to leave_actions.log
//            String logFile = "logs/leave_actions.log";
//            try (FileWriter fw = new FileWriter(logFile, true);
//                 BufferedWriter bw = new BufferedWriter(fw);
//                 PrintWriter out = new PrintWriter(bw)) {
//
//                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//                String logEntry = String.format("[%s] Employee: %s, Request: %s, Status: %s",
//                        timestamp, empId, requestId, status);
//                out.println(logEntry);
//            }
//
//        } catch (IOException e) {
//            System.err.println("Error logging leave action: " + e.getMessage());
//            // Don't throw the exception as logging failure shouldn't affect the main operation
//        }
//    }

    // Helper method to calculate working days between two dates
    private long calculateWorkingDays(LocalDate startDate, LocalDate endDate) {
        return startDate.datesUntil(endDate.plusDays(1))
                .filter(date -> date.getDayOfWeek() != DayOfWeek.SATURDAY &&
                        date.getDayOfWeek() != DayOfWeek.SUNDAY)
                .count();
    }
}
