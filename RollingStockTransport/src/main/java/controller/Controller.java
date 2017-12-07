package main.java.controller;

import main.java.model.RailwayStation;
import main.java.model.Train;
import main.java.model.entity.rail.PassengerWaggon;
import main.java.view.View;

import java.util.Comparator;

public class Controller {
    private RailwayStation railway;
    private View view;

    public Controller(RailwayStation railway, View view) {
        this.railway = railway;
        this.view = view;
    }

    public void userProcess() {
        //sort waggons for comfortable
    }

}
