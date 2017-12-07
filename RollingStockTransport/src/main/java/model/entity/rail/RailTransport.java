package main.java.model.entity.rail;

import java.time.LocalDate;

public abstract class RailTransport {
    private static int quantity = 0;
    private final int number = ++quantity;

    private int weight;
    private int wheelDiameter;
    private String name;
    private String color;
    private String description;
    private LocalDate make;

    public int getNumber() {
        return number;
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

    public String getDescription() {
        return description;
    }

    public LocalDate getMake() {
        return make;
    }

    public abstract String getIdentifierName();
    public abstract int capacity();

    public int numberOfRailwayTransport() {
        return quantity;
    }

    // Builder. Generic patterns
    public abstract class Builder <T extends Builder<T>> {

        /** The solution for the unchecked cast warning. */
        abstract T _this();

        public T weight(int weight){
            RailTransport.this.weight = weight;
            return _this();
        }

        public T wheelDiameter(int wheelDiameter) {
            RailTransport.this.wheelDiameter = wheelDiameter;
            return _this();
        }

        public T name(String name){
            RailTransport.this.name = name;
            return _this();
        }

        public T color(String color){
            RailTransport.this.color = color;
            return _this();
        }

        public T description(String description){
            RailTransport.this.description = description;
            return _this();
        }

        public T make(LocalDate date){
            RailTransport.this.make = date;
            return _this();
        }

        public abstract RailTransport build();
    }

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
                "\n number=" + number +
                "\n weight=" + weight +
                "\n wheelDiameter=" + wheelDiameter +
                "\n name='" + name + '\'' +
                "\n color='" + color + '\'' +
                "\n description='" + description + '\'' +
                "\n make=" + make +
                '}';
    }
}
