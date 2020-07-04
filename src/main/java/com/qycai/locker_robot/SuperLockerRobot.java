package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperLockerRobot extends LockerRobot {

    public SuperLockerRobot(List<Locker> lockers) throws LockerTypeMismatchWithRobot {
        super(lockers, "L");
    }

    @Override
    public Ticket save(Bag bag) throws LockerIsFullException {
        Optional<Locker> maxAvailableCapacityLocker = lockers.stream().max(Comparator.comparing(Locker::availableCapacity));
        if (maxAvailableCapacityLocker.isPresent()) {
            return maxAvailableCapacityLocker.get().save(bag);
        }
        return null;
    }
}
