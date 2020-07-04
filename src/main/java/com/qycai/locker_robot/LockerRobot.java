package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

import java.util.List;

abstract class LockerRobot {

    protected List<Locker> lockers;

    public LockerRobot(List<Locker> lockers, String lockerType) throws LockerTypeMismatchWithRobot {
        for (Locker locker : lockers) {
            if (locker.getType().equals(lockerType)) {
                this.lockers = lockers;
            } else {
                throw new LockerTypeMismatchWithRobot();
            }
        }
    }

    public Bag take(Ticket ticket) throws TicketIsInvalidException {
        for (Locker locker : lockers) {
            if (locker.hasBag(ticket)) {
                return locker.take(ticket);
            }
        }
        throw new TicketIsInvalidException();
    }

    public abstract Ticket save(Bag bag) throws LockerIsFullException;

}
