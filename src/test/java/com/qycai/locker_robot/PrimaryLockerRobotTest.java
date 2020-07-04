package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import com.qycai.locker_robot.exception.TicketIsInvalidException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimaryLockerRobotTest {
    @Test
    void should_return_ticket_and_save_bag_to_1st_locker_when_save_bag_given_primary_locker_robot_manager_two_M_locker_and_both_have_capacity() throws LockerIsFullException, TicketIsInvalidException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(2, "M");
        Locker locker2 = new Locker(3, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("M");

        Ticket ticket = primaryLockerRobot.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker1.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_return_ticket_and_save_bag_to_2nd_locker_when_save_bag_given_primary_locker_robot_manager_two_M_locker_and_1st_is_full() throws LockerIsFullException, TicketIsInvalidException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(1, "M");
        Locker locker2 = new Locker(3, "M");
        locker1.save(new Bag("M"));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("M");

        Ticket ticket = primaryLockerRobot.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker2.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_throw_lockerIsFullException_when_save_bag_given_primary_locker_robot_manager_two_M_locker_and_both_are_full() throws LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(1, "M");
        Locker locker2 = new Locker(1, "M");
        locker1.save(new Bag("M"));
        locker2.save(new Bag("M"));
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));

        assertThrows(LockerIsFullException.class, () -> primaryLockerRobot.save(new Bag("M")));
    }

    @Test
    void should_get_bag_when_take_bag_given_valid_ticket() throws LockerIsFullException, TicketIsInvalidException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(2, "M");
        Locker locker2 = new Locker(3, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Bag saveBag = new Bag("M");
        Ticket ticket = primaryLockerRobot.save(saveBag);

        Bag bag = primaryLockerRobot.take(ticket);

        assertEquals(saveBag, bag);
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_given_invalid_ticket() throws LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(2, "M");
        Locker locker2 = new Locker(3, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Bag saveBag = new Bag("M");
        primaryLockerRobot.save(saveBag);

        assertThrows(TicketIsInvalidException.class, () -> primaryLockerRobot.take(new Ticket()));
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_given_used_ticket() throws LockerIsFullException, TicketIsInvalidException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(2, "M");
        Locker locker2 = new Locker(3, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));
        Bag saveBag = new Bag("M");
        Ticket ticket = primaryLockerRobot.save(saveBag);
        primaryLockerRobot.take(ticket);

        assertThrows(TicketIsInvalidException.class, () -> primaryLockerRobot.take(ticket));
    }

    @Test
    void should_throw_lockerTypeMismatchWithRobot_when_config_locker_and_robot_given_S_locker_and_primaryLockerRobot() throws LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(2, "S");
        Locker locker2 = new Locker(3, "M");

        assertThrows(LockerTypeMismatchWithRobot.class, () -> new PrimaryLockerRobot(Arrays.asList(locker1, locker2)));
    }
}
