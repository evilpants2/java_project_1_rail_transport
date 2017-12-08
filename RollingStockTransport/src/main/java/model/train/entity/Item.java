package model.train.entity;

public class Item {
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
