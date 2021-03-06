package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import com.qycai.locker_robot.exception.TicketIsInvalidException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class LockerRobotManagerTest {
    @Test
    void should_return_ticket_and_saved_to_locker1_when_save_S_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_all_lockers_have_capacity() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(3, "S");
        Locker locker2 = new Locker(4, "M");
        Locker locker3 = new Locker(9, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));

        Bag savedBag = new Bag("S");
        Ticket ticket = manager.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker1.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_return_ticket_and_save_to_locker2_when_save_M_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_all_lockers_have_capacity() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(3, "S");
        Locker locker2 = new Locker(4, "M");
        Locker locker3 = new Locker(9, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));

        Bag savedBag = new Bag("M");
        Ticket ticket = manager.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker2.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_return_ticket_and_save_to_locker3_when_save_L_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_all_lockers_have_capacity() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(3, "S");
        Locker locker2 = new Locker(4, "M");
        Locker locker3 = new Locker(9, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));

        Bag savedBag = new Bag("L");
        Ticket ticket = manager.save(savedBag);

        assertNotNull(ticket);
        Bag bag = locker3.take(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_throw_lockerIsFullException_when_save_S_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_locker1_is_full() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(1, "S");
        Locker locker2 = new Locker(4, "M");
        Locker locker3 = new Locker(9, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        manager.save(new Bag("S"));

        assertThrows(LockerIsFullException.class, () -> manager.save(new Bag("S")));
    }

    @Test
    void should_throw_lockerIsFullException_when_save_M_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_locker2_is_full() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(5, "S");
        Locker locker2 = new Locker(1, "M");
        Locker locker3 = new Locker(9, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        manager.save(new Bag("M"));

        assertThrows(LockerIsFullException.class, () -> manager.save(new Bag("M")));
    }

    @Test
    void should_throw_lockerIsFullException_when_save_L_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_locker3_is_full() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(5, "S");
        Locker locker2 = new Locker(1, "M");
        Locker locker3 = new Locker(1, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        manager.save(new Bag("L"));

        assertThrows(LockerIsFullException.class, () -> manager.save(new Bag("L")));
    }

    @Test
    void should_get_bag_when_take_S_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_valid_ticket() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(5, "S");
        Locker locker2 = new Locker(1, "M");
        Locker locker3 = new Locker(1, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        Bag savedBag = new Bag("S");
        Ticket ticket = manager.save(savedBag);

        Bag bag = manager.take(ticket);

        assertNotNull(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_get_bag_when_take_M_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_valid_ticket() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(5, "S");
        Locker locker2 = new Locker(1, "M");
        Locker locker3 = new Locker(1, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        Bag savedBag = new Bag("M");
        Ticket ticket = manager.save(savedBag);

        Bag bag = manager.take(ticket);

        assertNotNull(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_get_bag_when_take_L_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_valid_ticket() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(5, "S");
        Locker locker2 = new Locker(1, "M");
        Locker locker3 = new Locker(8, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        Bag savedBag = new Bag("L");
        Ticket ticket = manager.save(savedBag);

        Bag bag = manager.take(ticket);

        assertNotNull(ticket);
        assertEquals(savedBag, bag);
    }

    @Test
    void should_throw_ticketIsInvalidException_when_take_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_invalid_ticket() throws LockerTypeMismatchWithRobot, LockerIsFullException, TicketIsInvalidException {
        Locker locker1 = new Locker(5, "S");
        Locker locker2 = new Locker(1, "M");
        Locker locker3 = new Locker(8, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        manager.save(new Bag("L"));

        assertThrows(TicketIsInvalidException.class, () -> manager.take(new Ticket()));
    }

}
