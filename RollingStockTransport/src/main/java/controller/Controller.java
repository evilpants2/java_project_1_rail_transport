package controller;

import static view.Multilingual.rs;

import model.train.RailwayStation;
import model.train.Trains;
import model.train.entity.PassengerWaggon;
import model.train.entity.Train;
import view.Multilingual;
import view.View;

public class Controller {
    private final RailwayStation railway;
    private final View view;
    private final Multilingual multilingual;

    public Controller(RailwayStation railway, View view) {
        this.railway = railway;
        this.view = view;
        multilingual = Multilingual.getInstances();
    }

    public void userProcess() {
        ProjectData.init(railway);
        Train train = railway.getTrain(0);
        // tasks
        Trains.sort(train, PassengerWaggon.comfortComparator());
        view.printCollection(train.getWaggons());
        view.println("================================================");
        view.println("Number of passengers: " + Trains.countPassengers(train));
        view.println("================================================");
        view.printCollection(Trains.diapason(train, 3, 5));


    }

}
