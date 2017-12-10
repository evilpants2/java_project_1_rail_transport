package model.dao.extract;

import model.entity.Passenger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtractPassenger {

    public static List<Passenger> extractPassengerList(ResultSet set)
            throws SQLException {
        List<Passenger> passengers = new ArrayList<>();
        while (set.next()){
            passengers.add(
                    new Passenger(set.getString("name"),
                            set.getInt("idpassenger"))
            );
        }
        return passengers;
    }

}
