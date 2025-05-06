package com.pluralsight;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(
                2,
                139.00,
                false,
                false,
                Room.RoomType.KING
        );
        Reservation reservation = new Reservation(
                room,
                3,
                true
        );
        Employee employee = new Employee(
                1,
                "John Doe",
                "Engineering",
                20.00,
                45
        );

        reservationDemo(reservation);
        employeeDemo(employee);
        roomCheckinDemo(room);
        employeeShiftDemo(employee);
        employeeDefaultShiftDemo(employee);
    }

    private static void employeeDefaultShiftDemo(Employee employee) {
        System.out.println("Employee default shift demo");
        System.out.println("-".repeat(5));

        employee.printPaymentInfo();

        System.out.println("-".repeat(5));
        System.out.println("Working default shift of 12 hours");
        employee.punchTimeCard();
        System.out.println("-".repeat(5));

        employee.printPaymentInfo();
        System.out.println("-".repeat(25));

    }

    private static void employeeShiftDemo(Employee employee) {
        System.out.println("Employee shift demo");
        System.out.println("-".repeat(5));

        employee.printPaymentInfo();

        System.out.println("-".repeat(5));
        System.out.println("Punching time card...");
        System.out.println("Working hours: 8:00 - 17:00");
        System.out.println("9 hours shift");
        System.out.println("Punching time card...");
        System.out.println("-".repeat(5));

        employee.punchTimeCard(
                LocalTime.of(8, 0),
                LocalTime.of(17, 0)
        );

        employee.printPaymentInfo();
        System.out.println("-".repeat(25));
    }

    private static void roomCheckinDemo(Room room) {
        System.out.println("Room check-in");
        System.out.println("Is room available: " + room.isAvailable());
        System.out.println("Checking in room...");
        room.checkIn();
        System.out.println("Is room available: " + room.isAvailable());
        System.out.println("Checking out room...");
        room.checkout();
        System.out.println("Is room available: " + room.isAvailable());
        System.out.println("Cleaning room...");
        room.clean();
        System.out.println("Is room available: " + room.isAvailable());
        System.out.println("-".repeat(25));
    }

    private static void employeeDemo(Employee employee) {
        System.out.println("Employee");
        System.out.println("-".repeat(25));
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Department: " + employee.getDepartment());
        System.out.println("Employee Pay Rate: " + employee.getPayRate());
        System.out.println("Employee Hours Worked: " + employee.getHoursWorked());
        System.out.println("Employee Regular Hours: " + employee.getRegularHours());
        System.out.println("Employee Overtime Hours: " + employee.getOvertimeHours());
        System.out.println("Employee Total Pay: " + employee.getTotalPay());
        System.out.println("-".repeat(25));
    }

    private static void reservationDemo(Reservation reservation) {
        reservation.getRoom().setRoomType("DOUBLE");
        System.out.println("-".repeat(25));
        System.out.println("Room");
        System.out.println("-".repeat(25));

        System.out.println("Room Type: " + reservation.getRoom().getRoomType().getName());
        System.out.println("Number of Beds: " + reservation.getRoom().getNumberOfBeds());
        System.out.println("Is Room Available: " + reservation.getRoom().isAvailable());
        System.out.println("Price per Night: " + reservation.getRoom().getPricePerNight());
        System.out.println("Total Price: " + reservation.getReservationTotal());
        System.out.println("-".repeat(25));
    }
}