package model.dao.mysql;

import model.dao.PassengerDAO;
import model.entity.Passenger;
import java.sql.*;
import java.util.List;

import static model.dao.extract.ExtractPassenger.extractPassengerList;

public class MysqlPassenger implements PassengerDAO {
    private Connection connection;

    MysqlPassenger(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Passenger e) {
        return 0;
    }

    @Override
    public List<Passenger> findAll() {
        final String sql = "select * from passenger";
        try (Statement stat = connection.createStatement()){
            ResultSet rs = stat.executeQuery(sql);
            return extractPassengerList(rs);
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
            System.err.println(e.getSQLState());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Passenger findById(int id) {
        return null;
    }

    @Override
    public boolean update(Passenger e) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
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
