package models;

import java.util.List;

public class Sandwich extends Product{
    private String bread;
    private String size;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> otherToppings;
    private List<String> sauces;
    private boolean toasted;

    public Sandwich(String bread, String size, List<String> meats, List<String> cheeses, List<String> otherToppings, List<String> sauces, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.meats = meats;
        this.cheeses = cheeses;
        this.otherToppings = otherToppings;
        this.sauces = sauces;
        this.toasted = toasted;
        this.name = size + " " + bread + " sandwich";
        this.price = calculatePrice();
    }

    private double calculatePrice() {
        double breadPrice = switch (size) {
            case "4" -> 5.50;
            case "8" ->7.00;
            case "12" ->8.50;
            default -> 0.0;
        };

        double meatPrice = meats.size() * switch (size) {
            case "4" -> 1.00;
            case "8" -> 2.00;
            case "12" -> 3.00;
            default -> 0.0;
        };

        double cheesePrice = cheeses.size() * switch (size) {
            case "4" -> 0.75;
            case "8" -> 1.50;
            case "12" -> 2.25;
            default -> 0.0;
        };
        return  breadPrice + meatPrice + cheesePrice;
    }

    @Override
    public String getDescription() {
        return String.format(
                "Sandwich (%s, %s) \nMeats: %s\nCheeses: %s\nToppings: %s\nSauces: %s\nToasted: %s",
                size, bread, meats, cheeses,otherToppings,sauces,toasted ? "Yes" : "No");
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
