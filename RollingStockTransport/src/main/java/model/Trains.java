package model;

import model.entity.Passenger;
import model.entity.PassengerWaggon;
import model.entity.RailTransport;
import model.entity.Train;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Trains {
    //sort
    public static void sort(Train train, Comparator<RailTransport> comp) {
        train.getWaggons().sort(comp);
    }

    //counts passenger & baggage
    public static Tuple<Integer, Integer> count(Train train) {
        Integer numberOfPassengers = 0;
        Integer weight = 0;
        PassengerWaggon pw;
        List<Passenger> passengers;
        for (RailTransport rt : train.getWaggons()) {
            if((pw = PassengerWaggon.isPassenger(rt)) != null) {
                numberOfPassengers += pw.getPassengers().size();
                passengers = pw.getPassengers();
                for (Passenger p : passengers) {
                    weight += p.getBaggageWeight();
                }
            }
        }
        return new Tuple<>(numberOfPassengers, weight);
    }

    @Deprecated
    public static int countBaggage(Train train) {
        int weight = 0;
        PassengerWaggon pw;
        List<Passenger> passengers;
        for (RailTransport rt : train.getWaggons()) {
            if((pw = PassengerWaggon.isPassenger(rt)) != null) {
                passengers = pw.getPassengers();
                for (Passenger p : passengers) {
                    weight += p.getBaggageWeight();
                }
            }
        }
        return weight;
    }
    //waggons are in diapason for number of passengers
    public static List<PassengerWaggon> diapason(Train train, int left, int right) {
        List<PassengerWaggon> waggons = new ArrayList<>();
        if(left < 0 || right < 0 || left > right) {
            throw new IllegalArgumentException();
        }
        PassengerWaggon pw;
        for (RailTransport rt : train.getWaggons()) {
            if((pw = PassengerWaggon.isPassenger(rt)) != null) {
                if (pw.getCountPassengers() >= left && pw.getCountPassengers() <= right)
                waggons.add(pw);
            }
        }
        return waggons;
    }

}
