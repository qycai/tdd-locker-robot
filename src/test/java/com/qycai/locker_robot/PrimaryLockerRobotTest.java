package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PrimaryLockerRobotTest {
    @Test
    void should_return_ticket_when_save_bag_to_1st_locker_given_primary_locker_robot_manager_two_M_locker_and_both_have_capacity() throws LockerIsFullException {
        Bag bag = new Bag("M");
        Locker locker1 = new Locker(2, "M");
        Locker locker2 = new Locker(3, "M");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Arrays.asList(locker1, locker2));

        Ticket ticket = primaryLockerRobot.save(bag);

        assertNotNull(ticket);

    }

}
