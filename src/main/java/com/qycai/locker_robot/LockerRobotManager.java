package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

import java.util.List;

public class LockerRobotManager {
    private List<Locker> lockers;
    private List<LockerRobot> robots;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> robots) {
        this.lockers = lockers;
        this.robots = robots;
    }

    public Ticket save(Bag bag) throws LockerIsFullException {
        switch (bag.getType()) {
            case "S":
                for (Locker locker : lockers) {
                    return locker.save(bag);
                }
                break;
            case "M":
                for (LockerRobot robot : robots) {
                    for (Locker locker : robot.lockers) {
                        if (locker.getType().equals("M")) {
                            return robot.save(bag);
                        }
                    }
                }
                break;
            case "L":
                for (LockerRobot robot : robots) {
                    for (Locker locker : robot.lockers) {
                        if (locker.getType().equals("L")) {
                            return robot.save(bag);
                        }
                    }
                }
                break;
        }
        return null;
    }

    public Bag take(Ticket ticket) throws TicketIsInvalidException {
        for (Locker locker : lockers) {
            return locker.take(ticket);
        }
        return null;
    }
}
