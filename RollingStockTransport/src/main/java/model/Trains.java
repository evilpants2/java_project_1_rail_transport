package main.java.model;

import main.java.model.entity.rail.RailTransport;

import java.util.Comparator;

public final class Trains {

    //sort
    public static void sort(Train train, Comparator<RailTransport> comparator) {
        train.getWaggons().sort(comparator);
    }

    //counts passenger

    //counts them baggage

}
