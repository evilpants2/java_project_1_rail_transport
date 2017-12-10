package model.dao.extract;

import model.entity.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtractTicket {

    public static Ticket extractOneTicket(ResultSet set) throws SQLException {
        if (set.next()) {
            return Ticket.newTicket()
                    .from(set.getString("departure"))
                    .to(set.getString("arrival"))
                    .dateDeparture(set.getTimestamp("departure_date")
                            .toLocalDateTime())
                    .dateArrive(set.getTimestamp("arrival_date")
                            .toLocalDateTime())
                    .ticketID(set.getInt("idticket"))
                    .waggon(set.getString("waggon_name"))
                    .waggonNumber(set.getInt("waggon"))
                    .trainID(set.getInt("idtrain"))
                    .place(set.getInt("place"))
                    .build();
        }
        return null;
    }

}