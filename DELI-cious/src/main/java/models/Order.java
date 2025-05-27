package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<String > sandwiches = new ArrayList<>();
    private List<String> drinks = new ArrayList<>();
    private List<String> chips = new ArrayList<>();

    public void addSandwich(String sandwich) {
        sandwiches.add(0, sandwich);
    }

    public void addDrink(String drink) {
        drinks.add(0, drink);
    }

    public void addChips(String chip) {
        chips.add(0, chip);
    }

    public List<String> getSandwiches() {
        return sandwiches;
    }

    public List<String> getDrinks() {
        return drinks;
    }

    public List<String> getChips() {
        return chips;
    }

    public void clear() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
    }

    public boolean isEmpty() {
        return sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty();
    }
}
