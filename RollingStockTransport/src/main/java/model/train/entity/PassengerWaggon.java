package model.train.entity;

import model.train.ComfortLevel;
import model.train.RailConst;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PassengerWaggon extends RailTransport
        implements java.io.Serializable, Cloneable {
    private static final long serialVersionUID = -3056760678953206590L;
    private int numberOfSeats;
    private ComfortLevel comfort;
    private List<Passenger> passengers;

    public PassengerWaggon(int id, int weight, int wheelDiameter, String name,
                           LocalDate manufactureDate, String color,
                           int numberOfSeats, ComfortLevel comfort) {
        super(id, weight, wheelDiameter,
                name, manufactureDate, color);
        passengers = new ArrayList<>();
        this.numberOfSeats = numberOfSeats;
        this.comfort = comfort;
    }

    public int getCountPassengers() {
        return passengers.size();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger p) {
        if(passengers.size() >= numberOfSeats) {
            throw new RuntimeException("all places have already reserved");
        }
        passengers.add(p);
    }

    public static PassengerWaggon isPassenger(RailTransport rt) {
        if (rt.getClass() == PassengerWaggon.class) {
            return (PassengerWaggon) rt;
        }
        return null;
    }

    @Override
    public String getIdentifierName() {
        return getName() + "-" + comfort.toString();
    }

    @Override
    public int capacity() {
        return RailConst.PASSENGER_LOAD_CAPACITY;
    }

    public static ComfortComparator comfortComparator() {
        return new ComfortComparator();
    }

    public static class ComfortComparator implements Comparator<RailTransport> {
        @Override
        public int compare(RailTransport o1, RailTransport o2) {
            PassengerWaggon pw1 = (PassengerWaggon) o1;
            PassengerWaggon pw2 = (PassengerWaggon) o2;
            if (pw1.comfort == pw2.comfort) return 0;
            int dif = pw1.comfort.ordinal() - pw2.comfort.ordinal();
            return dif / (Math.abs(dif));
        }
    }

    @Override
    public String toString() {
        return getIdentifierName();
    }
}
