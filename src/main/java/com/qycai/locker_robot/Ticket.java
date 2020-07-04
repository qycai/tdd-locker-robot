package com.qycai.locker_robot;

public class Ticket {
    private TicketType type = TicketType.GIVEN_BY_S_Locker;

    public void setType(TicketType type) {
        this.type = type;
    }

    public TicketType getType() {
        return type;
    }
}
