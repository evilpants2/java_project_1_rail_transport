package model.entity;

import java.util.ArrayList;
import java.util.List;

public class Passenger implements java.io.Serializable {
    private static final long serialVersionUID = -3056760678953206590L;

    //private transient static int counter;

    private final int passengerID;
    private final String name;
    private List<Item> items;
    private Ticket ticket;

    public Passenger(String name, int passengerID) {
        this.name = name;
        this.passengerID = passengerID;
        this.items = new ArrayList<>();
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item get(int index) {
        return items.get(index);
    }

    public void add(Item element) {
        items.add(element);
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

    public int getPassengerID() {
        return passengerID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            Passenger p = (Passenger) obj;
            return p.passengerID == this.passengerID;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * passengerID;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passengerID=" + passengerID +
                '}';
    }
}
