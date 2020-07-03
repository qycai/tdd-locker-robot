package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.BagAndLockerSizeIsMismatchException;
import com.qycai.locker_robot.exception.LockerIsFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    @Test
    void should_return_ticket_when_save_bag_given_S_locker_and_S_bag_and_locker_is_not_full() throws LockerIsFullException, BagAndLockerSizeIsMismatchException {
        Bag bag = new Bag("S");
        Locker locker = new Locker(3, "S");

        Ticket ticket = locker.save(bag);

        assertNotNull(ticket);
    }

    @Test
    void should_throw_lockerIsFullException_when_save_bag_given_S_locker_and_S_bag_and_locker_is_full() throws LockerIsFullException, BagAndLockerSizeIsMismatchException {
        Bag bag = new Bag("S");
        Locker locker = new Locker(1, "S");
        locker.save(bag);

        assertThrows(LockerIsFullException.class, () -> locker.save(new Bag("S")));
    }

    @Test
    void should_throw_bagAndLockerSizeIsMismatchException_when_save_bag_given_S_locker_and_M_bag() {
        Bag bag = new Bag("M");
        Locker locker = new Locker(1, "S");

        assertThrows(BagAndLockerSizeIsMismatchException.class, () -> locker.save(bag));
    }

    @Test
    void should_throw_bagAndLockerSizeIsMismatchException_when_save_bag_given_S_locker_and_L_bag() {
        Bag bag = new Bag("L");
        Locker locker = new Locker(1, "S");

        assertThrows(BagAndLockerSizeIsMismatchException.class, () -> locker.save(bag));
    }
}
