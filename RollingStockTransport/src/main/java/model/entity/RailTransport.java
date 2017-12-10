package model.entity;

import java.time.LocalDate;

public abstract class RailTransport
        implements java.io.Serializable {
    private static final long serialVersionUID = -3056760678953206590L;

    private int transportID;
    private int indexNumber;
    private int weight;
    private int wheelDiameter;
    private String name;
    private LocalDate manufactureDate;
    private String color;

    public abstract class BuilderBase <T extends BuilderBase<T>> {

        abstract T This();

        public T transportID(int transportID) {
            RailTransport.this.transportID = transportID;
            return This();
        }

        public T indexNumber(int indexNumber) {
            RailTransport.this.indexNumber = indexNumber;
            return This();
        }

        public T weight(int weight) {
            RailTransport.this.weight = weight;
            return This();
        }

        public T wheelDiameter(int wheelDiameter) {
            RailTransport.this.wheelDiameter = wheelDiameter;
            return This();
        }

        public T name(String name) {
            RailTransport.this.name = name;
            return This();
        }

        public T manufactureDate(LocalDate manufactureDate) {
            RailTransport.this.manufactureDate = manufactureDate;
            return This();
        }

        public T color(String color) {
            RailTransport.this.color = color;
            return This();
        }

        public abstract RailTransport build();
    }

    public int getTransportID() {
        return transportID;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getWheelDiameter() {
        return wheelDiameter;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public abstract String getIdentifierName();

    public abstract int capacity();

    @Override
    public int hashCode() {
        return transportID * 193;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj instanceof RailTransport) {
            RailTransport rt = (RailTransport) obj;
            return rt.transportID == transportID;
        }
        return false;
    }

    @Override
    public String toString() {
        return "RailTransport{" +
                "\n transportID=" + transportID +
                "\n weight=" + weight +
                "\n wheelDiameter=" + wheelDiameter +
                "\n name='" + name + '\'' +
                "\n color='" + color + '\'' +
                "\n manufactureDate=" + manufactureDate +
                '}';
    }
}
