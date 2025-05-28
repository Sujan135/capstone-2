package manager;

import models.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddSandwichScreen {
    private Scanner scanner;

    public AddSandwichScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich createSandwich(){
        System.out.println("\n--- Add Sandwich ---");

        System.out.println("Select bread");
        String bread = scanner.nextLine();

        System.out.println("Select size");
        String size = scanner.nextLine();

        System.out.println("---Toppings---");

        List<String> meats = new ArrayList<>();
        System.out.println("Add meats");
        String meatInput = scanner.nextLine();
        if (!meatInput.isBlank()) {
            for (String meat : meatInput.split(",")) {
                meats.add(meat.trim());
            }
        }

        List<String> cheeses = new ArrayList<>();
        System.out.println("Add cheeses");
        String cheeseInput = scanner.nextLine();
        if (!cheeseInput.isBlank()) {
            for (String cheese : cheeseInput.split(",")){
                cheeses.add(cheese.trim());
            }
        }

        List<String> toppings = new ArrayList<>();
        System.out.println("Add other toppings");
        String toppingInput = scanner.nextLine();
        if (!toppingInput.isBlank()) {
            for (String topping : toppingInput.split(",")){
                toppings.add(topping.trim());
            }
        }

        List<String> sauces = new ArrayList<>();
        System.out.println("Add sauces");
        String sauceInput = scanner.nextLine();
        if (!sauceInput.isBlank()) {
            for (String sauce : sauceInput.split(",")){
                sauces.add(sauce.trim());
            }
        }

        System.out.println("Would you like the sandwich toasted? (yes/no): ");
        String input = scanner.nextLine();
        boolean toasted = input.equalsIgnoreCase("yes");


        return null;
    }

}
