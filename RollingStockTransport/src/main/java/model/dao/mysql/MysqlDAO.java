package model.dao.mysql;

import model.dao.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDAO extends DAOFactory{

    @Override
    public BaggageDAO baggageDAO() {
        return new MysqlBaggage(getConnection());
    }

    @Override
    public PassengerDAO passengerDAO() {
        return new MysqlPassenger(getConnection());
    }

    @Override
    public TicketDAO ticketDAO() {
        return new MysqlTicket(getConnection());
    }

    @Override
    public TransportDAO transportDAO() {
        return new MysqlTransport(getConnection());
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rail",
                    "vlad",
                    "610917"
            );
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            throw new RuntimeException(e);
        }

    }

    public static class TestMysqlDAO {
        public static void main(String[] args) throws SQLException {
            MysqlDAO factory = (MysqlDAO) DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            System.out.println(factory.getConnection().getCatalog());
        }
    }

}
