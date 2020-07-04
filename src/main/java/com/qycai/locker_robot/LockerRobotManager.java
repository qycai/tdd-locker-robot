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
                    Ticket ticket = locker.save(bag);
                    ticket.setType(TicketType.GIVEN_BY_S_Locker);
                    return ticket;
                }
                break;
            case "M":
                for (LockerRobot robot : robots) {
                    for (Locker locker : robot.lockers) {
                        if (locker.getType().equals("M")) {
                            Ticket ticket = robot.save(bag);
                            ticket.setType(TicketType.GIVEN_BY_M_Locker);
                            return ticket;
                        }
                    }
                }
                break;
            case "L":
                for (LockerRobot robot : robots) {
                    for (Locker locker : robot.lockers) {
                        if (locker.getType().equals("L")) {
                            Ticket ticket = robot.save(bag);
                            ticket.setType(TicketType.GIVEN_BY_L_Locker);
                            return ticket;
                        }
                    }
                }
                break;
        }
        return null;
    }

    public Bag take(Ticket ticket) throws TicketIsInvalidException {
        if (ticket.getType() == null) {
            throw new TicketIsInvalidException();
        }
        Bag bag = null;
        switch (ticket.getType()) {
            case GIVEN_BY_S_Locker:
                for (Locker locker : lockers) {
                    bag = locker.take(ticket);
                }
                break;
            case GIVEN_BY_M_Locker:
                for (LockerRobot robot : robots) {
                    for (Locker locker : robot.lockers) {
                        if (locker.getType().equals("M")) {
                            bag = robot.take(ticket);
                        }
                    }
                }
                break;
            case GIVEN_BY_L_Locker:
                for (LockerRobot robot : robots) {
                    for (Locker locker : robot.lockers) {
                        if (locker.getType().equals("L")) {
                            bag = robot.take(ticket);
                        }
                    }
                }
                break;
        }
        return bag;
    }
}
