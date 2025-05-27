package models;

import java.util.List;

public class Sandwich {
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
    }

    @Override
    public String toString() {
        return String.format("Sandwich (%s, %s) \nMeats: %s\nCheeses: %\nToppings: %s\nSauces: %s\nToasted: %s",
                size, bread, meats, cheeses,otherToppings,sauces,toasted ? "Yes" : "No");
    }
}
