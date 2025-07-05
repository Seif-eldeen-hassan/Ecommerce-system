package model;

public class ShippableItem {
    private Shippable item;
    private int quantity;

    public ShippableItem(Shippable item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Shippable getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTotalWeight() {
        double totalWeight = item.getWeight() * quantity;

        if (totalWeight >= 1000) {
            double inKg = totalWeight / 1000.0;
            return String.format("%.2f kg", inKg);
        } else {
            return String.format("%.0f g", totalWeight);
        }
    }

    public double getTotalNumericWeight(){
        return item.getWeight() * quantity;
    }
}