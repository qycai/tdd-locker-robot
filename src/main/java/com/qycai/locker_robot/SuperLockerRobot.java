package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperLockerRobot {
    private List<Locker> lockers;

    public SuperLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) throws LockerIsFullException {
        Optional<Locker> maxAvailableCapacityLocker = lockers.stream().max(Comparator.comparing(Locker::availableCapacity));
        if (maxAvailableCapacityLocker.isPresent()) {
            return maxAvailableCapacityLocker.get().save(bag);
        }
        return null;
    }
}
