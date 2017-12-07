package main.java.model;

import main.java.model.entity.passenger.Passenger;
import main.java.model.entity.passenger.Ticket;
import java.util.List;

public final class RailwayStation {
    private List<Train> trains;

    public void takeTrain(Passenger passenger, int track) {
        if(passenger == null || track < 0 || track >= trains.size()) {
            throw new IllegalArgumentException();
        }
        Train passengerTrain = trains.get(track);
        // check ticket
        Ticket ticket = passenger.getTicket();
        if (ticket != null && ticket.getTrain().equals(passengerTrain.getIdTrain())) {

        }
        //passengerTrain.getWaggons().get(ticket)
    }

}
