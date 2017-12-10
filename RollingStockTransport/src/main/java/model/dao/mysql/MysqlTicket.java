package model.dao.mysql;

import model.dao.TicketDAO;
import model.entity.Passenger;
import model.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static model.dao.extract.ExtractTicket.extractOneTicket;

public class MysqlTicket implements TicketDAO {
    private Connection connection;

    MysqlTicket(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Ticket e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Ticket> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Ticket findById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(Ticket e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void selectPassengerTicket(Passenger p) {
        final String sql = "select * from ticket where idpassenger = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, p.getPassengerID());
            ResultSet set = statement.executeQuery();
            p.setTicket(extractOneTicket(set));
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
