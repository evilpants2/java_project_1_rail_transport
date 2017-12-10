package controller;

import model.entity.Train;

class UserData {
    private static UserData instances;

    private UserData() {}

    static UserData getInstances() {
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

    void setCurrentTrain(Train train) {
        this.current = train;
    }

    Train getCurrentTrain() {
        return current;
    }
}
