package main.java.model.entity.rail;

public class Locomotive extends RailTransport
        implements Traction, java.io.Serializable, Cloneable{
    private int speed;
    private Engine engine;

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

    public static Builder newLocomotive() {
        return new Locomotive().new Builder();
    }

    public class Builder extends RailTransport.Builder<Builder> {

        @Override
        Builder _this() {
            return this;
        }

        public Builder engine(Engine engine){
            Locomotive.this.engine = engine;
            return _this();
        }

        public Builder speed(int speed){
            Locomotive.this.speed = speed;
            return _this();
        }

        @Override
        public RailTransport build() {
            return Locomotive.this;
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\n Locomotive{" +
                "\n speed=" + speed +
                "\n engine=" + engine +
                '}';
    }
}
