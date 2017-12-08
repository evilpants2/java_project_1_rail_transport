package model.train.entity;

import model.train.Traction;

import java.util.List;

public final class Train {
    private static int quantity;
    private final int idTrain = quantity++;

    private RailTransport head;
    private RailTransport tail;
    private List<RailTransport> waggons;

    public Train(RailTransport tr, List<RailTransport> waggons) {
        if(!isTraction(tr))
            throw new RuntimeException("Need traction rail transport !");
        this.head = tr;
        this.waggons = waggons;
    }

    public Train(RailTransport head, RailTransport tail, List<RailTransport> waggons) {
        this(head, waggons);
        if (!isTraction(tail))
            throw new RuntimeException("Need traction rail transport !");
        this.tail = tail;
    }

    private boolean isTraction(RailTransport rt) {
        return rt instanceof Traction;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            Train t = (Train) obj;
            return this.idTrain == t.idTrain;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 59 * idTrain;
    }

    @Override
    public String toString() {
        return "Train: " + idTrain;
    }
}
