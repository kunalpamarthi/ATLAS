package org.example.Model;

import lombok.Data;

@Data
public class LeaveRequest {
    private String empId;
    private String requestId;
    private String startDate;
    private String endDate;
    private String reason;
    private String status;
}
