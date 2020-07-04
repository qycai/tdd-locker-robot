package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import com.qycai.locker_robot.exception.TicketIsInvalidException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class SuperLockerRobotTest {
    @Test
    void should_return_ticket_and_saved_to_1st_locker_when_save_bag_given_superLockerRobot_manage_two_L_lockers_and_1st_locker_capacity_is_more_than_2nd_locker() throws TicketIsInvalidException, LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(5, "L");
        Locker locker2 = new Locker(2, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("L");

        Ticket ticket = superLockerRobot.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker1.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_return_ticket_and_saved_to_2nd_locker_when_save_bag_given_superLockerRobot_manage_two_L_lockers_and_1st_locker_capacity_is_less_than_2nd_locker() throws TicketIsInvalidException, LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(2, "L");
        Locker locker2 = new Locker(6, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("L");

        Ticket ticket = superLockerRobot.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker2.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_return_ticket_and_saved_to_1st_locker_when_save_bag_given_superLockerRobot_manage_two_L_lockers_and_1st_locker_capacity_equals_to_2nd_locker() throws TicketIsInvalidException, LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(2, "L");
        Locker locker2 = new Locker(2, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("L");

        Ticket ticket = superLockerRobot.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker1.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_throw_lockerIsFullException_when_save_bag_given_superLockerRobot_manage_two_L_lockers_and_both_locker_have_no_capacity() throws LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(1, "L");
        Locker locker2 = new Locker(1, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        superLockerRobot.save(new Bag("L"));
        superLockerRobot.save(new Bag("L"));

        assertThrows(LockerIsFullException.class, () -> superLockerRobot.save(new Bag("L")));
    }

    @Test
    void should_get_bag_when_take_bag_given_valid_ticket() throws LockerIsFullException, TicketIsInvalidException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(3, "L");
        Locker locker2 = new Locker(10, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("L");
        Ticket ticket = superLockerRobot.save(savedBag);

        Bag bag = superLockerRobot.take(ticket);

        assertNotNull(ticket);
        assertEquals(savedBag, bag);

    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_given_invalid_ticket() throws LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(3, "L");
        Locker locker2 = new Locker(10, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("L");
        superLockerRobot.save(savedBag);

        assertThrows(TicketIsInvalidException.class, () -> superLockerRobot.take(new Ticket()));
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_by_superLockerRobot_given_ticket_is_returned_by_primaryLockerRobot() throws LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(3, "M");
        Locker locker2 = new Locker(10, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker1));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker2));
        Bag savedBag = new Bag("L");
        Ticket ticket = primaryLockerRobot.save(savedBag);

        assertThrows(TicketIsInvalidException.class, () -> superLockerRobot.take(ticket));
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_by_superLockerRobot_given_ticket_is_returned_by_locker_which_is_not_managed_by_superLockerRobot() throws LockerIsFullException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(3, "L");
        Locker locker2 = new Locker(10, "S");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker1));
        Bag savedBag = new Bag("S");
        Ticket ticket = locker2.save(savedBag);

        assertThrows(TicketIsInvalidException.class, () -> superLockerRobot.take(ticket));
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_given_used_ticket() throws LockerIsFullException, TicketIsInvalidException, LockerTypeMismatchWithRobot {
        Locker locker1 = new Locker(3, "L");
        Locker locker2 = new Locker(10, "L");
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Arrays.asList(locker1, locker2));
        Bag savedBag = new Bag("L");
        Ticket ticket = superLockerRobot.save(savedBag);
        superLockerRobot.take(ticket);

        assertThrows(TicketIsInvalidException.class, () -> superLockerRobot.take(ticket));
    }

    @Test
    void should_throw_lockerTypeMismatchWithRobot_when_config_locker_and_robot_given_S_locker_and_superLockerRobot() throws LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(2, "S");
        Locker locker2 = new Locker(3, "L");

        assertThrows(LockerTypeMismatchWithRobot.class, () -> new SuperLockerRobot(Arrays.asList(locker1, locker2)));
    }

    @Test
    void should_throw_lockerTypeMismatchWithRobot_when_config_locker_and_robot_given_M_locker_and_superLockerRobot() throws LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(2, "M");
        Locker locker2 = new Locker(3, "L");

        assertThrows(LockerTypeMismatchWithRobot.class, () -> new SuperLockerRobot(Arrays.asList(locker1, locker2)));
    }

}
