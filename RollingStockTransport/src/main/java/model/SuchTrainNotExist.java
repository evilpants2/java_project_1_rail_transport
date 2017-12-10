package model;

public class SuchTrainNotExist extends RuntimeException {

    private int index;

    public SuchTrainNotExist(String message, int index) {
        super(message);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
