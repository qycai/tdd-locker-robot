package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;

import java.util.List;

public class LockerRobotManager {
    private List<Locker> lockers;
    private List<LockerRobot> robots;

    public LockerRobotManager(List<Locker> lockers, List<LockerRobot> robots) {
        this.lockers = lockers;
        this.robots = robots;
    }

    public Ticket save(Bag bag) throws LockerIsFullException {
        if (bag.getType().equals("S")) {
            for (Locker locker : lockers) {
                return locker.save(bag);
            }
        } else if (bag.getType().equals("M")) {
            for (LockerRobot robot : robots) {
                for (Locker locker : robot.lockers) {
                    if (locker.getType().equals("M")) {
                        return robot.save(bag);
                    }
                }
            }
        } else if (bag.getType().equals("L")) {
            for (LockerRobot robot : robots) {
                for (Locker locker : robot.lockers) {
                    if (locker.getType().equals("L")) {
                        return robot.save(bag);
                    }
                }
            }
        }
        return null;
    }
}
