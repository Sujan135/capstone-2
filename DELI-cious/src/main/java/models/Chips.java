package models;

public class Chips{
    private final String type;
    private final double price;

    public Chips(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
