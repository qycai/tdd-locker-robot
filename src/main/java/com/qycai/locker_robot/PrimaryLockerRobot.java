package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.LockerTypeMismatchWithRobot;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

import java.util.List;

public class PrimaryLockerRobot extends LockerRobot {

    public PrimaryLockerRobot(List<Locker> lockers) throws LockerTypeMismatchWithRobot {
        super(lockers, "M");
    }

    @Override
    public Ticket save(Bag bag) throws LockerIsFullException {
        for (Locker locker : lockers) {
            if (!locker.isFull()) {
                return locker.save(bag);
            }
        }
        throw new LockerIsFullException();
    }
}
