package model.train;

public enum Engine {
    TURBOSHAFT(3600), DIESEL(4200), PETROL(4500), ELECTRIC_MOTOR(4300);

    // in kW
    private int power;

    Engine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
