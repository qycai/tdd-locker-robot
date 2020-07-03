package com.qycai.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {
    @Test
    void should_return_ticket_when_save_bag_given_S_locker_and_S_bag_and_locker_is_not_full() throws LockerIsFullException {
        Bag bag = new Bag("S");
        Locker locker = new Locker(3, "S");

        Ticket ticket = locker.save(bag);

        assertNotNull(ticket);
    }

    @Test
    void should_throw_lockerIsFullException_when_save_bag_given_S_locker_and_S_bag_and_locker_is_full() throws LockerIsFullException {
        Bag bag = new Bag("S");
        Locker locker = new Locker(1, "S");
        locker.save(bag);

        assertThrows(LockerIsFullException.class, () -> locker.save(new Bag("S")));
    }
}
