package com.qycai.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerTest {
    @Test
    void should_return_ticket_when_save_bag_given_S_locker_and_S_bag() {
        Bag bag = new Bag("S");
        Locker locker = new Locker(3, "S");

        Ticket ticket = locker.save(bag);

        assertNotNull(ticket);
    }
}
