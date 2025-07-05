package model;

public class ShipExpirableProduct extends Product implements Expirable, Shippable {
    private double weight;
    private boolean expired;
    public ShipExpirableProduct(String name, double price, int quantity , double weight , boolean expired) {
        super(name, price, quantity);
        this.weight = weight;
        this.expired = expired;
    }
    public double getWeight() {
        return weight;
    }
    public boolean isExpired() {
        return expired;
    }

    public String getname() {
        return super.getName();
    }
}
