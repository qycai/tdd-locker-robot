package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;

import java.util.List;

public class PrimaryLockerRobot {
    private List<Locker> lockers;

    public PrimaryLockerRobot(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public Ticket save(Bag bag) throws LockerIsFullException {
        return lockers.get(0).save(bag);
    }
}
