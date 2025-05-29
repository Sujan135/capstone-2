package models;

public enum SandwichSize {
    FOUR_INCH(5.50, 7.00, 8.50),
    EIGHT_INCH(7.00, 8.50, 10.00),
    TWELVE_INCH(8.50, 10.00, 11.50);

    private final double breadPrice;
    private final double meatPrice;
    private final double cheesePrice;

    SandwichSize(double breadPrice, double meatPrice, double cheesePrice) {
        this.breadPrice = breadPrice;
        this.meatPrice = meatPrice;
        this.cheesePrice = cheesePrice;
    }

    public double getBreadPrice() {
        return breadPrice;
    }

    public double getMeatPrice() {
        return meatPrice;
    }

    public double getCheesePrice() {
        return cheesePrice;
    }
}
