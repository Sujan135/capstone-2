package manager;

import models.Drink;

import java.util.Scanner;

public class AddDrinkScreen {
    private Scanner scanner;

    public AddDrinkScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Drink createDrink() {
        System.out.println("Enter drink size: ");
        String size = scanner.nextLine();
        System.out.println("Enter drink Flavor: ");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }
}
