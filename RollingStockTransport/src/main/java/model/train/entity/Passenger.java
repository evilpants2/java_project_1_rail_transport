package model.train.entity;

import java.util.ArrayList;
import java.util.List;

public class Passenger {

    private final String name;
    private List<Item> items;
    private Ticket ticket;

    public Passenger(String name) {
        this.name = name;
        this.items = new ArrayList<>();
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

    public int getBaggageWeight() {
        int weight = 0;
        for (Item item : items) {
            weight += item.getWeight();
        }
        return weight;
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
