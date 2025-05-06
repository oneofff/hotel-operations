package com.pluralsight;

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
        Employee employee = new Employee(
                1,
                "John Doe",
                "Engineering",
                20.00,
                45
        );

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

    }
}