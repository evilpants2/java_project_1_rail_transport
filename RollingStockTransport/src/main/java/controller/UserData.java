package controller;

import model.train.entity.Train;

public class UserData {
    private static UserData instances;

    private UserData() {}

    public static UserData getInstances() {
        if(instances == null) {
            synchronized (UserData.class) {
                if(instances == null){
                    instances = new UserData();
                }
            }
        }
        return instances;
    }

    private Train current;

    public void setCurrentTrain(Train train) {
        this.current = current;
    }

    public Train getCurrentTrain() {
        return current;
    }
}
