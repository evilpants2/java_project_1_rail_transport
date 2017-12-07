package main.java.model.entity.passenger;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private final String name;
    private List<Item> items = new ArrayList<>();
    private Ticket ticket;

    public Passenger(String name) {
        this.name = name;
    }

    public Item get(int index) {
        return items.get(index);
    }

    public void add(int index, Item element) {
        items.add(index, element);
    }

    public Item remove(int index) {
        return items.remove(index);
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
