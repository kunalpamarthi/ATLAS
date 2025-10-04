package org.example.Model;

import lombok.Data;

@Data
public class Salary {
    private String empId;
    private String month;
    private double basic;
    private double pfContribution;
    private double hra;
    private double netPay;
}
