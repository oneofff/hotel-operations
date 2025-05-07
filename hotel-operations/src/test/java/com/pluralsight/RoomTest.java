package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void isAvailableShouldReturnTrueWhenRoomIsNotDirtyAndNotOccupied() {
        //given
        Room room = new Room();
        room.setDirty(false);
        room.setOccupied(false);

        //when
        boolean result = room.isAvailable();

        //then
        assertTrue(result);
    }

    @Test
    void isAvailableShouldFalseTrueWhenRoomIsDirtyAndNotOccupied() {
        //given
        Room room = new Room();
        room.setDirty(true);
        room.setOccupied(false);

        //when
        boolean result = room.isAvailable();

        //then
        assertFalse(result);
    }

    @Test
    void isAvailableShouldReturnFalseWhenRoomIsDirtyAndNotOccupied() {
        //given
        Room room = new Room();
        room.setDirty(true);
        room.setOccupied(true);

        //when
        boolean result = room.isAvailable();

        //then
        assertFalse(result);
    }


    @Test
    void checkInShouldThrowExceptionWhenRoomIsDirtyAndOccupied() {
        //given
        Room room = new Room();
        room.setDirty(true);
        room.setOccupied(true);

        //when and then
        assertThrows(IllegalStateException.class, room::checkIn);
    }

    @Test
    void checkInShouldThrowExceptionWhenRoomIsNotDirtyAndOccupied() {
        //given
        Room room = new Room();
        room.setDirty(false);
        room.setOccupied(true);

        //when and then
        assertThrows(IllegalStateException.class, room::checkIn);
    }

    @Test
    void checkInSetDirtyAndOccupiedWhenRoomIsNotDirtyAndNotOccupied() {
        //given
        Room room = new Room();
        room.setDirty(false);
        room.setOccupied(false);

        //when
        room.checkIn();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void checkOutShouldThrowExceptionWhenRoomIsNotDirtyAndNotOccupied() {
        //given
        Room room = new Room();
        room.setDirty(false);
        room.setOccupied(false);

        //when and then
        assertThrows(IllegalStateException.class, room::checkout);
    }

    @Test
    void checkOutSetDirtyAndOccupiedWhenRoomIsDirtyAndOccupied() {
        //given
        Room room = new Room();
        room.setDirty(true);
        room.setOccupied(true);

        //when
        room.checkout();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void checkOutShouldSetDirtyAndOccupiedWhenRoomIsNotDirtyAndOccupied() {
        //given
        Room room = new Room();
        room.setDirty(false);
        room.setOccupied(true);

        //when
        room.checkout();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void cleanShouldThrowExceptionWhenRoomIsNotDirtyAndNotOccupied() {
        //given
        Room room = new Room();
        room.setDirty(false);
        room.setOccupied(false);

        //when and then
        assertThrows(IllegalStateException.class, room::clean);
    }

    @Test
    void cleanShouldSetDirtyAndOccupiedWhenRoomIsDirtyAndNotOccupied() {
        //given
        Room room = new Room();
        room.setDirty(true);
        room.setOccupied(false);

        //when
        room.clean();

        assertFalse(room.isDirty());
    }

    @Test
    void cleanShouldSetDirtyAndOccupiedWhenRoomIsNotDirtyAndOccupied() {
        //given
        Room room = new Room();
        room.setDirty(false);
        room.setOccupied(true);

        //when
        room.clean();

        assertFalse(room.isDirty());
    }

    @Test
    void setRoomTypeShouldSetRoomType() {
        //given
        Room room = new Room();
        String roomType = "KING";

        //when
        room.setRoomType(roomType);

        //then
        assertEquals(Room.RoomType.KING, room.getRoomType());
    }

    @Test
    void setRoomTypeShouldThrowExceptionWhenRoomTypeIsInvalid() {
        //given
        Room room = new Room();
        String roomType = "INVALID";

        //when and then
        assertThrows(IllegalArgumentException.class, () -> room.setRoomType(roomType));
    }

}