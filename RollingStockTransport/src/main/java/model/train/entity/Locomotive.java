package model.train.entity;

import model.train.Engine;
import model.train.RailConst;
import model.train.Traction;

import java.time.LocalDate;

public class Locomotive extends RailTransport
        implements Traction, java.io.Serializable, Cloneable{
    private static final long serialVersionUID = -3056760678953206590L;

    private final int speed;
    private final Engine engine;

    public Locomotive(int id, int weight, int wheelDiameter,
                      String name, LocalDate manufactureDate,
                      String color, int speed, Engine engine) {
        super(id, weight, wheelDiameter,
                name, manufactureDate, color);
        this.speed = speed;
        this.engine = engine;
    }

    @Override
    public String getIdentifierName() {
        return getName() + "-" + engine.toString();
    }

    @Override
    public int capacity() {
        return RailConst.LOCOMOTIVE_LOAD_CAPACITY;
    }

    // in kN
    @Override
    public int tractionForce() {
        return engine.getPower() * 3600 / speed;
    }

    @Override
    public String toString() {
        return "Locomotive" + getIdentifierName();

    }
}
