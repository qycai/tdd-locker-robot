package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.BagAndLockerSizeIsMismatchException;
import com.qycai.locker_robot.exception.LockerIsFullException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private String size;
    private Map<Ticket, Bag> record = new HashMap<>();

    public Locker(int capacity, String size) {
        this.capacity = capacity;
        this.size = size;
    }

    public Ticket save(Bag bag) throws LockerIsFullException, BagAndLockerSizeIsMismatchException {
        if (record.size() >= capacity) {
            throw new LockerIsFullException();
        }
        if (!bag.getSize().equals(this.size)) {
            throw new BagAndLockerSizeIsMismatchException();
        }
        Ticket ticket = new Ticket();
        record.put(ticket, bag);
        return ticket;
    }
}
