package model.dao;

import model.entity.Locomotive;
import model.entity.PassengerWaggon;
import model.entity.RailTransport;

import java.util.List;

public interface TransportDAO extends GenericDAO<RailTransport> {

    List<PassengerWaggon> selectPassengerWaggons(int trainID);
    Locomotive selectLocomotive(int trainID, int order);

}
