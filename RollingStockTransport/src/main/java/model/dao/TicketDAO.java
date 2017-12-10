package model.dao;

import model.entity.Passenger;
import model.entity.Ticket;

public interface TicketDAO extends GenericDAO<Ticket> {

    void selectPassengerTicket(Passenger p);

}
