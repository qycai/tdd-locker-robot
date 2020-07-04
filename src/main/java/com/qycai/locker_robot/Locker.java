package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

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

    public Ticket save(Bag bag) throws LockerIsFullException {
        if (record.size() >= capacity) {
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        record.put(ticket, bag);
        return ticket;
    }

    public Bag take(Ticket ticket) throws TicketIsInvalidException {
        if (!record.containsKey(ticket)) {
            throw new TicketIsInvalidException();
        }
        Bag bag = record.get(ticket);
        record.remove(ticket);
        return bag;
    }
}
