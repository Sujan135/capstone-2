package services;

import models.*;

import java.util.Arrays;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Order createOrder() {
        return new Order();
    }

    @Override
    public void addSandwich(Order order) {
        System.out.println("Select sandwich size:");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");
        System.out.println("-------------------");
        SandwichSize size = switch (scanner.nextInt()) {
            case 1 -> SandwichSize.FOUR_INCH;
            case 2 -> SandwichSize.EIGHT_INCH;
            case 3 -> SandwichSize.TWELVE_INCH;
            default -> SandwichSize.FOUR_INCH;
        };
        scanner.nextLine();

        System.out.println("Select bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.println("--------------------");
        BreadType bread = switch (scanner.nextInt()) {
            case 1 -> BreadType.WHITE;
            case 2 -> BreadType.WHEAT;
            case 3 -> BreadType.RYE;
            case 4 -> BreadType.WRAP;
            default -> BreadType.WHITE;
        };
        scanner.nextLine();

        Sandwich sandwich = new Sandwich(size, bread);
        addToppings(sandwich);
        System.out.println("Would you like the sandwich toasted? (y/n): ");
        sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("y"));
        order.addSandwich(sandwich);
    }

    private void addToppings(Sandwich sandwich) {
            Topping[] meats = {
                    new Topping("Steak", ToppingType.MEAT),
                    new Topping("Ham", ToppingType.MEAT),
                    new Topping("Salami", ToppingType.MEAT),
                    new Topping("Roast Beef", ToppingType.MEAT),
                    new Topping("Chicken", ToppingType.MEAT),
                    new Topping("Bacon", ToppingType.MEAT),
            };
            Topping[] cheeses = {
                    new Topping("American", ToppingType.CHEESE),
                    new Topping("Provolone", ToppingType.CHEESE),
                    new Topping("Cheddar", ToppingType.CHEESE),
                    new Topping("Swiss", ToppingType.CHEESE),
            };
            Topping[] regulars = {
                    new Topping("Lettuce", ToppingType.REGULAR),
                    new Topping("Peppers", ToppingType.REGULAR),
                    new Topping("Onions", ToppingType.REGULAR),
                    new Topping("Tomatoes", ToppingType.REGULAR),
                    new Topping("Jalapeños", ToppingType.REGULAR),
                    new Topping("Cucumbers", ToppingType.REGULAR),
                    new Topping("Pickles", ToppingType.REGULAR),
                    new Topping("Guacamole", ToppingType.REGULAR),
                    new Topping("Mushrooms", ToppingType.REGULAR),
            };
            Topping[] sauces = {
                    new Topping("Mayo", ToppingType.SAUCE),
                    new Topping("Mustard", ToppingType.SAUCE),
                    new Topping("Ketchup", ToppingType.SAUCE),
                    new Topping("Ranch", ToppingType.SAUCE),
                    new Topping("Thousand Islands", ToppingType.SAUCE),
                    new Topping("Vinaigrette", ToppingType.SAUCE),
            };

            // Repeat this pattern for each type
            selectToppingsByType("meat", meats, sandwich);
            selectToppingsByType("cheese", cheeses, sandwich);
            selectToppingsByType("toppings", regulars, sandwich);
            selectToppingsByType("sauces", sauces, sandwich);

    }

    private void selectToppingsByType(String label, Topping[] options, Sandwich sandwich) {
        System.out.println("Add " + label + " (choose all that apply");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d) %s%n", i + 1, options[i].getName());
        }
        int choice;
        while (true) {
            System.out.print("> ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) break;
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid choice.");
                continue;
            }
            Topping topping = options[choice - 1];
            System.out.printf("Add extra %s? (y/n)%n> ", topping.getName());
            String extraInput = scanner.nextLine().trim();
//            boolean extra = scanner.nextLine().equalsIgnoreCase("y");
            int quantity = 1;
            if (extraInput.equalsIgnoreCase("y")) {
                System.out.print("How many extra servings?\n> ");
                int extraServings = scanner.nextInt();
                scanner.nextLine();
                quantity += extraServings;
                sandwich.addTopping(topping, quantity);
                // Keep asking for more toppings
            } else if (extraInput.equalsIgnoreCase("n")) {
                sandwich.addTopping(topping, quantity);
                // Instead of asking for 0, just break and move to next category immediately
                break;
            } else {
                System.out.println("Invalid input, please enter 'y' or 'n'.");
                // Do not add topping; retry this topping
                continue;
            }
            sandwich.addTopping(topping, quantity);
        }


    }


    @Override
    public void addDrink(Order order) {
        System.out.println("Select drink size (1: Small, 2: Medium, 3: Large): ");
        String size = switch (scanner.nextInt()) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Small";
        };
        scanner.nextLine();
        System.out.println("Enter drink flavor: ");
        String flavor = scanner.nextLine();
        double price = size.equals("Small") ? 2.00 : size.equals("Medium") ? 2.50 : 3.00;
        order.addDrink(new Drink(size, flavor, price));
    }

    @Override
    public void addChips(Order order) {
        System.out.println("Enter chip type: ");
        String type = scanner.nextLine();
        order.addChips(new Chips(type, 1.50));
    }

    @Override
    public void checkout(Order order) {
        System.out.println("Order Details:\n" + order.getDetails());
        System.out.println("Confirm order? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            ReceiptService receiptService = new ReceiptServiceImpl();
            receiptService.saveReceipt(order);
            System.out.println("Order completed!");
        } else {
            cancelOrder(order);
        }
    }

    @Override
    public void cancelOrder(Order order) {
        System.out.println("Order cancelled.");
    }
}