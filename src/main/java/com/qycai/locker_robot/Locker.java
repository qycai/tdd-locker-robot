package com.qycai.locker_robot;

import com.qycai.locker_robot.exception.LockerIsFullException;
import com.qycai.locker_robot.exception.TicketIsInvalidException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private String type;
    private Map<Ticket, Bag> record = new HashMap<>();

    public String getType() {
        return type;
    }

    public Locker(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
    }

    public Ticket save(Bag bag) throws LockerIsFullException {
        if (isFull()) {
            throw new LockerIsFullException();
        }
        Ticket ticket = new Ticket();
        record.put(ticket, bag);
        return ticket;
    }

    public boolean isFull() {
        return record.size() >= capacity;
    }

    public Bag take(Ticket ticket) throws TicketIsInvalidException {
        if (!hasBag(ticket)) {
            throw new TicketIsInvalidException();
        }
        Bag bag = record.get(ticket);
        record.remove(ticket);
        return bag;
    }

    public boolean hasBag(Ticket ticket) {
        return record.containsKey(ticket);
    }

    public int availableCapacity() {
        return capacity - record.size();
    }
}
