package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) throws LockerTypeMismatchWithRobot {
        for (Locker locker : lockers) {
            if (locker.getType().equals("M")) {
                this.lockers = lockers;
            } else {
                throw new LockerTypeMismatchWithRobot();
            }
        }
    }

    public Ticket save(Bag bag) throws LockerIsFullException {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
    }

    public Bag take(Ticket ticket) throws TicketIsInvalidException {
        for (Locker locker : lockers) {
            if (locker.hasBag(ticket)) {
                return locker.take(ticket);
            }
        }
        throw new TicketIsInvalidException();
    }
}
