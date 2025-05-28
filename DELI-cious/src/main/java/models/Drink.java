package models;

public class Drink extends Product{
    private String size;

    public Drink(String size) {
        this.size = size;
        this.name = size + "Drink";
        this.price = switch (size) {
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
}
