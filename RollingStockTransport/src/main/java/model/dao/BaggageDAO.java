package model.dao;

import model.entity.Item;
import model.entity.Passenger;

public interface BaggageDAO extends GenericDAO<Item> {

    void selectBaggage(Passenger passenger);

}
