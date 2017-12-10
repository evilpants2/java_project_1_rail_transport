package model.dao.mysql;

import model.dao.BaggageDAO;
import model.entity.Item;
import model.entity.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static model.dao.extract.ExtractBaggage.extractItemList;

public class MysqlBaggage implements BaggageDAO {
    private Connection connection;

    MysqlBaggage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Item e) {
        return 0;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findById(int id) {
        return null;
    }

    @Override
    public boolean update(Item e) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void selectBaggage(Passenger p) {
        final String sql = "select iditem, item, weight from item" +
                " join baggage using (iditem)" +
                " where idpassenger = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, p.getPassengerID());
            ResultSet set = statement.executeQuery();
            p.setItems(extractItemList(set));
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
