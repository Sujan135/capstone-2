package manager;

import models.Chips;

import java.util.Scanner;

public class AddChipsScreen {
    private Scanner scanner;

    public AddChipsScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Chips createChips() {
        System.out.println("Enter chips type:");
        String type = scanner.nextLine();
        return new Chips(type);
    }
}
