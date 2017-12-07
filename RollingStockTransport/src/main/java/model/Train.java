package main.java.model;

import main.java.model.entity.rail.RailTransport;
import main.java.model.entity.rail.Traction;

import java.util.List;

public final class Train {
    private static int quantity;
    private final int idTrain = quantity++;
    private RailTransport head;
    private RailTransport tail;
    private List<RailTransport> waggons;

    public Train(RailTransport tr, List<RailTransport> waggons) {
        if(!isTraction(tr)) throw new RuntimeException("Need traction rail transport !");
        this.head = tr;
        this.waggons = waggons;
    }

    public Train(RailTransport head, RailTransport tail, List<RailTransport> waggons) {
        this(head, waggons);
        if(!isTraction(tail)) throw new RuntimeException("Need traction rail transport !");
        this.tail = tail;
    }

    private boolean isTraction(RailTransport tr) {
        return tr instanceof Traction;
    }

    public static int numberOfTrains() {
        return quantity;
    }

    public int getIdTrain() {
        return idTrain;
    }

    public RailTransport getHead() {
        return head;
    }

    public void setHead(RailTransport head) {
        this.head = head;
    }

    public RailTransport getTail() {
        return tail;
    }

    public void setTail(RailTransport tail) {
        this.tail = tail;
    }

    public List<RailTransport> getWaggons() {
        return waggons;
    }
}
