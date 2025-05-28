package models;

public class Drink extends Product{
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.name = size + " " + flavor + " Drink";
        this.price = calculatePrice(this.size);
    }
    private double calculatePrice(String size) {
        return switch (size) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> 0.0;
        };
    }
    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
