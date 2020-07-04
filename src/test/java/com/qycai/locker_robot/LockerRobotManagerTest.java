package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import org.junit.jupiter.api.Test;
import sun.awt.image.PixelConverter;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerRobotManagerTest {
    @Test
    void should_return_ticket_when_save_bag_given_manager_manage_locker1_primaryLockerRobot_with_locker2_superLockerRobot_with_locker3_and_all_lockers_have_capacity() throws LockerTypeMismatchWithRobot, LockerIsFullException {
        Locker locker1 = new Locker(3, "S");
        Locker locker2 = new Locker(4, "M");
        Locker locker3 = new Locker(9, "L");
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(Collections.singletonList(locker2));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(Collections.singletonList(locker3));
        LockerRobotManager manager = new LockerRobotManager(Collections.singletonList(locker1), Arrays.asList(primaryLockerRobot, superLockerRobot));
        Ticket ticket = manager.save(new Bag("S"));

        assertNotNull(ticket);
    }
}
