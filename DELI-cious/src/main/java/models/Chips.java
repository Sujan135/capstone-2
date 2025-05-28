package models;

public class Chips extends Product{
    private String type;

    public Chips(String type) {
        this.type = type;
        this.name = type + " chips";
        this.price = 1.50;
    }

    @Override
    public String getDescription() {
        return name;
    }
}
