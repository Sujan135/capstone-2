package models;

public enum DrinkSize {
    SMALL, MEDIUM, LARGE;

    @Override
    public String toString() {
        return switch (this) {
            case SMALL -> "small";
            case MEDIUM -> "medium";
            case LARGE -> "large";
            default -> "";
        };
    }
}
