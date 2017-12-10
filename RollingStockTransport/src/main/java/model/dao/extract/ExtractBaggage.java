package model.dao.extract;

import model.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtractBaggage {
    public static List<Item> extractItemList(ResultSet set) throws SQLException {
        List<Item> items = new ArrayList<>();
        while (set.next()){
            items.add(new Item(
                    set.getInt("iditem"),
                    set.getInt("weight"),
                    set.getString("item")
            ));
        }
        return items;
    }
}
