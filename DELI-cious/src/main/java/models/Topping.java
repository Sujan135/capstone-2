package models;

import java.util.HashMap;

public class Topping {
    private String name;
    private ToppingType type;
    private HashMap<SandwichSize, Double> price;

    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
        this.price = new HashMap<>();
        initializePrices();
    }

    private void initializePrices() {
        switch (type) {
            case MEAT:
                price.put(SandwichSize.FOUR_INCH, 1.00);
                price.put(SandwichSize.EIGHT_INCH,2.00);
                price.put(SandwichSize.TWELVE_INCH, 3.00);
                break;
            case CHEESE:
                price.put(SandwichSize.FOUR_INCH,0.75);
                price.put(SandwichSize.EIGHT_INCH, 1.50);
                price.put(SandwichSize.TWELVE_INCH, 2.25);
                break;
            case REGULAR:
            case SAUCE:
            case SIDE:
                price.put(SandwichSize.FOUR_INCH, 0.00);
                price.put(SandwichSize.EIGHT_INCH, 0.00);
                price.put(SandwichSize.TWELVE_INCH, 0.00);
        }
    }

    public String getName() {
        return name;
    }

    public ToppingType getType() {
        return type;
    }

    public double getPrice(SandwichSize size) {
    return price.getOrDefault(size, 0.00);
    }

    public double getExtraPrice(SandwichSize size) {
        if (type == ToppingType.MEAT) {
            return size == SandwichSize.FOUR_INCH ? 0.50 : size == SandwichSize.EIGHT_INCH ? 1.00 : 1.50;
        } else if (type == ToppingType.CHEESE) {
            return  size == SandwichSize.FOUR_INCH ? 0.30 : size == SandwichSize.EIGHT_INCH ? 0.60: 0.90;
        }
        return 0.00;
    }
}

