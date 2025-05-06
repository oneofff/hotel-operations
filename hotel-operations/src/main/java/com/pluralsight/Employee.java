package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private final int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final double REGULAR_HOURS_CEILING = 40.0;


    public double getRegularHours() {
        return Math.min(hoursWorked, REGULAR_HOURS_CEILING);
    }

    public double getOvertimeHours() {
        return Math.max(0.0, hoursWorked - REGULAR_HOURS_CEILING);
    }

    public double getTotalPay() {
        return getRegularHours()  * payRate +
               getOvertimeHours() * payRate * OVERTIME_MULTIPLIER;
    }
}
