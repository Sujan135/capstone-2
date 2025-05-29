package models;

import java.util.HashMap;
import java.util.Map;

public class Sandwich {
    private SandwichSize size;
    private BreadType bread;
    private HashMap<Topping, Integer> toppings;
    private boolean isToasted;

    public Sandwich(SandwichSize size, BreadType bread) {
        this.size = size;
        this.bread = bread;
        this.toppings = new HashMap<>();
        this.isToasted = false;
    }

    public void addTopping(Topping topping, int quantity) {
        toppings.merge(topping, quantity, Integer::sum);
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double calculatePrice() {
        double price = size.getBreadPrice();
        for (HashMap.Entry<Topping, Integer> entry : toppings.entrySet()) {
            Topping topping = entry.getKey();
            int quantity = entry.getValue();
            price += topping.getPrice(size);
            if (quantity > 1) {
                price += (quantity - 1) * topping.getExtraPrice(size);
            }
        }
        return price;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append(size).append(" ").append(bread).append(" sandwich");
        if (isToasted) details.append(" (toasted)");
        details.append("\nToppings:\n");
        for (Map.Entry<Topping, Integer> entry : toppings.entrySet()) {
            details.append("- ").append(entry.getKey().getName()).append(" (x").append(entry.getValue()).append(")\n");
        }
        return details.toString();
    }
}