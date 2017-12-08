package model.train;

import model.train.entity.*;

import java.util.ArrayList;
import java.util.List;

public final class RailwayStation {
    private List<Train> trains;

    public RailwayStation() {
        trains = new ArrayList<>();
    }

    public boolean addTrain(Train train) {
        return trains.add(train);
    }

    public boolean removeTrain(Train train) {
        return trains.remove(train);
    }

    public Train getTrain(int index) {
        return trains.get(index);
    }

    public void takeTrain(Passenger passenger, int track) {
        if(passenger == null || track < 0 || track >= trains.size()) {
            throw new IllegalArgumentException();
        }
        Train pt = trains.get(track);
        // check ticket
        Ticket ticket = passenger.getTicket();
        if (ticket != null && ticket.getTrainID() == pt.getIdTrain()) {
            // success
            RailTransport rt = pt.getWaggons().get(ticket.getWaggonNumber());
            PassengerWaggon pw = (PassengerWaggon) rt;
//            if (pw.getIdentifierName().equals(ticket.getWaggon())) {
//                pw.addPassenger(passenger);
//            }
            pw.addPassenger(passenger);
        }
        //passengerTrain.getWaggons().get(ticket)
    }

}
