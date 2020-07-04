package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

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

    public Bag take(Ticket ticket) throws TicketIsInvalidException {
        for (Locker locker : lockers) {
            if (locker.hasBag(ticket)) {
                return locker.take(ticket);
            }
        }
        return null;
    }
}
