package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich> sandwiches;
    private final List<Drink> drinks;
    private final List<Chips> chips;
    private final LocalDateTime orderTime;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculatePrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Order Time: ").append(orderTime).append("\n\n");
        details.append("Sandwiches:\n");
        for (Sandwich sandwich : sandwiches) {
            details.append(sandwich.getDetails()).append("\n");
        }
        details.append("Drinks:\n");
        for (Drink drink : drinks) {
            details.append("- ").append(drink.getFlavor()).append(" (").append(drink.getSize()).append(")\n");
        }
        details.append("Chips:\n");
        for (Chips chip : chips) {
            details.append("- ").append(chip.getType()).append("\n");
        }
        details.append("Total: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return details.toString();
    }

    public String getReceiptFileName() {
        return orderTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
    }
}