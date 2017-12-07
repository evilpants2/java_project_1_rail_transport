package main.java.model.entity.rail;

import java.util.Comparator;

public class PassengerWaggon extends RailTransport
        implements java.io.Serializable, Cloneable {
    private int numberOfSeats;
    private ComfortLevel comfort;
    private int countPassengers;

    private PassengerWaggon() {
        // private constructor
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public void addPassenger() {
        if(countPassengers >= numberOfSeats) {
            throw new RuntimeException("all places have already reserved");
        }
        this.countPassengers++;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public ComfortLevel getComfort() {
        return comfort;
    }

    @Override
    public String getIdentifierName() {
        return getName() + "-" + comfort.toString();
    }

    @Override
    public int capacity() {
        return RailConst.PASSENGER_LOAD_CAPACITY;
    }

    public static Builder newPassengerWaggon() {
        return new PassengerWaggon().new Builder();
    }

    public class Builder extends RailTransport.Builder<Builder> {

        @Override
        Builder _this() {
            return this;
        }

        public Builder numberOfSeats(int numberOfSeats) {
            PassengerWaggon.this.numberOfSeats = numberOfSeats;
            return _this();
        }

        public Builder comfort(ComfortLevel comfort) {
            PassengerWaggon.this.comfort = comfort;
            return _this();
        }

        @Override
        public PassengerWaggon build() {
            return PassengerWaggon.this;
        }
    }

    public static class ComfortComparator implements Comparator<PassengerWaggon> {
        @Override
        public int compare(PassengerWaggon o1, PassengerWaggon o2) {
            if (o1.comfort == o2.comfort) return 0;
            int dif = o1.comfort.ordinal() - o2.comfort.ordinal();
            return -dif / (Math.abs(dif));
        }

        public static ComfortComparator comfortComparator() {
            return new ComfortComparator();
        }
    }

    // ???, create clone
    @Override
    protected PassengerWaggon clone() throws CloneNotSupportedException {
        return (PassengerWaggon) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + "\n PassengerWaggon{" +
                "\n numberOfSeats=" + numberOfSeats +
                "\n comfort=" + comfort +
                '}';
    }
}
