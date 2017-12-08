package model.train.entity;

import java.io.Serializable;

public class Item implements Serializable {
    private static final long serialVersionUID = -3056760678953206590L;

    private final String itemName;
    private final int weight;

    public Item(String itemName, int weight) {
        this.itemName = itemName;
        this.weight = weight;
    }

    public String getItemName() {
        return itemName;
    }

    public int getWeight() {
        return weight;
    }
}
