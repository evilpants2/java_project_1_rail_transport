package model.train.entity;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class RailTransport
        implements java.io.Serializable {
    private static final long serialVersionUID = -3056760678953206590L;

    private final int transportID;
    private final int weight;
    private final int wheelDiameter;
    private final String name;
    private final LocalDate manufactureDate;
    private final String color;

    RailTransport(int transportID, int weight, int wheelDiameter,
                  String name, LocalDate manufactureDate, String color) {
        this.transportID = transportID;
        this.weight = weight;
        this.wheelDiameter = wheelDiameter;
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.color = color;
    }

    public int getTransportID() {
        return transportID;
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
        return getIdentifierName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj instanceof RailTransport) {
            RailTransport rt = (RailTransport) obj;
            return rt.getIdentifierName().equals(this.getIdentifierName());
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
