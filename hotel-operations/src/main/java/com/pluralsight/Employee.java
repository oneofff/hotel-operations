package com.pluralsight;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

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
        return getRegularHours() * payRate +
                getOvertimeHours() * payRate * OVERTIME_MULTIPLIER;
    }

    public void punchTimeCard(LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
        hoursWorked += startTime.until(endTime, ChronoUnit.HOURS);
    }

    public void punchTimeCard() {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusHours(12);
        hoursWorked += startTime.until(endTime, ChronoUnit.HOURS);
    }

    public void printPaymentInfo() {
        System.out.println("Employee Name: " + this.getName());
        System.out.println("Employee Pay Rate: " + this.getPayRate());
        System.out.println("Employee Hours Worked: " + this.getHoursWorked());
        System.out.println("Employee Total Pay: " + this.getTotalPay());
    }

}
