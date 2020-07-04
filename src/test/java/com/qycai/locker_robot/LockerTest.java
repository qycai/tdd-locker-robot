package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.TicketIsInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_get_bag_when_take_bag_given_valid_ticket() throws LockerIsFullException, TicketIsInvalidException {
        Bag savedBag = new Bag("S");
        Locker locker = new Locker(3, "S");
        Ticket ticket = locker.save(savedBag);

        Bag bag = locker.take(ticket);

        assertEquals(savedBag, bag);
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_given_invalid_ticket() throws LockerIsFullException {
        Bag savedBag = new Bag("S");
        Locker locker = new Locker(3, "S");
        locker.save(savedBag);

        assertThrows(TicketIsInvalidException.class, () -> locker.take(new Ticket()));
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_given_used_ticket() throws LockerIsFullException, TicketIsInvalidException {
        Bag savedBag = new Bag("S");
        Locker locker = new Locker(3, "S");
        Ticket ticket = locker.save(savedBag);
        locker.take(ticket);

        assertThrows(TicketIsInvalidException.class, () -> locker.take(ticket));
    }
}
