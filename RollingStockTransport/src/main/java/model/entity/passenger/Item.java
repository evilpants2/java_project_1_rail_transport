package main.java.model.entity.passenger;

public class Item {
    private String itemName;
    private int weight;

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
