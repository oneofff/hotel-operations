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
        Hotel hotel = new Hotel(
                "Hotel California",
                10,
                20
        );

        reservationDemo(reservation);
        employeeDemo(employee);
        roomCheckinDemo(room);
        employeeShiftDemo(employee);
        employeeDefaultShiftDemo(employee);
        hotelDemo(hotel);
    }

    private static void hotelDemo(Hotel hotel) {
        System.out.println("Hotel");

        System.out.println("-".repeat(5));
        System.out.println("Hotel Name: " + hotel.getName());
        System.out.println("Number of Suites: " + hotel.getNumberOfSuites());
        System.out.println("Number of Rooms: " + hotel.getNumberOfRooms());
        System.out.println("Booked Suites: " + hotel.getBookedSuites());
        System.out.println("Booked Basic Rooms: " + hotel.getBookedBasicsRooms());
        System.out.println("Available Rooms: " + hotel.getAvailableRooms());
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("-".repeat(5));

        System.out.println("Booking 2 rooms...");
        boolean booked = hotel.bookRoom(2, false);
        System.out.println("Booking 2 rooms: " + (booked ? "Success" : "Failed"));
        System.out.println("Available Rooms: " + hotel.getAvailableRooms());
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("-".repeat(5));

        System.out.println("Booking 2 suites...");
        booked = hotel.bookRoom(2, true);
        System.out.println("Booking 2 suites: " + (booked ? "Success" : "Failed"));
        System.out.println("Available Rooms: " + hotel.getAvailableRooms());
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("-".repeat(5));

        System.out.println("Booking 250 rooms...");
        booked = hotel.bookRoom(250, false);
        System.out.println("Booking 250 rooms: " + (booked ? "Success" : "Failed"));
        System.out.println("Available Rooms: " + hotel.getAvailableRooms());
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("-".repeat(25));
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