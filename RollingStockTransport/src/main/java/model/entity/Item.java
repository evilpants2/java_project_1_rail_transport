package model.entity;

import java.io.Serializable;

public class Item implements Serializable {
    private static final long serialVersionUID = -3056760678953206590L;

    private final int itemID;
    private final String itemName;
    private final int weight;

    public Item(int itemID, int weight,
                String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.weight = weight;
    }

    public int getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return 179 * itemID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            Item i = (Item) obj;
            return i.itemID == itemID;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
