package models;

public class Topping {
    private String name;
    private int extras;

    public Topping(String name, int extras) {
        this.name = name;
        this.extras = extras;
    }

    public String getName() {
        return name;
    }

    public int getExtras() {
        return extras;
    }

    public void addExtra() {
        this.extras++;
    }
}


