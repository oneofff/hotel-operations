package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    void getRegularHoursShouldReturnAllHoursWhenHoursWorkedBelowCeiling() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(30.0);
        //when
        double regularHours = employee.getRegularHours();

        //then
        assertEquals(30.0, regularHours);
    }

    @Test
    void getRegularHoursShouldReturnCeilingHoursWhenHoursWorkedExceedsCeiling() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(45.0);

        //when
        double regularHours = employee.getRegularHours();

        //then
        assertEquals(40.0, regularHours);
    }

    @Test
    void getOvertimeHoursShouldReturnZeroWhenHoursWorkedBelowCeiling() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(30.0);

        //when
        double overtimeHours = employee.getOvertimeHours();

        //then
        assertEquals(0.0, overtimeHours);
    }


    @Test
    void getOvertimeHoursShouldReturnHoursAboveCeilingWhenHoursWorkedExceedsCeiling() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(45.0);

        //when
        double overtimeHours = employee.getOvertimeHours();

        //then
        assertEquals(5.0, overtimeHours);
    }

    @Test
    void getTotalPayShouldReturnCorrectPayForOnlyRegularHours() {
        //given
        Employee employee = new Employee();
        employee.setPayRate(20.0);
        employee.setHoursWorked(30.0);

        //when
        double totalPay = employee.getTotalPay();

        //then
        assertEquals(600.0, totalPay);
    }

    @Test
    void getTotalPayShouldReturnCorrectPayForRegularAndOvertimeHours() {
        //given
        Employee employee = new Employee();
        employee.setPayRate(20.0);
        employee.setHoursWorked(50.0);

        //when
        double totalPay = employee.getTotalPay();

        //then
        assertEquals(1100.0, totalPay);
    }

    @Test
    void punchTimeCardWithStartAndEndTimeAddHoursWhenValidInput() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(10.0);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);

        //when
        employee.punchTimeCard(startTime, endTime);

        //then
        assertEquals(18.0, employee.getHoursWorked());
    }

    @Test
    void punchTimeCardWithStartAndEndTimeAccumulateHoursWhenCalledMultipleTimes() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(5.0);

        //when
        employee.punchTimeCard(LocalTime.of(8, 0), LocalTime.of(12, 0));
        employee.punchTimeCard(LocalTime.of(13, 0), LocalTime.of(17, 0));

        //then
        assertEquals(13.0, employee.getHoursWorked());
    }

    @Test
    void punchTimeCardWithStartAndEndTimeShouldThrowExceptionWhenStartTimeAfterEndTime() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(10.0);
        LocalTime startTime = LocalTime.of(17, 0);
        LocalTime endTime = LocalTime.of(9, 0);

        //when and then
        assertThrows(IllegalArgumentException.class, () ->
                employee.punchTimeCard(startTime, endTime)
        );
    }

    @Test
    void punchTimeCardDefaultAddTwelveHoursWhenCalled() {
        //given
        Employee employee = new Employee();
        employee.setHoursWorked(20.0);

        //when
        employee.punchTimeCard(); // Adds 12 hours

        //then
        assertEquals(32.0, employee.getHoursWorked());
    }
}