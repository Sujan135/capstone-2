package services;

import models.*;

import utils.InputUtils;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Order createOrder() {
        return new Order();
    }

    @Override
    public void addSandwich(Order order) {
        System.out.println("Select sandwich size:");
        System.out.printf("1) 4\"  -$%.2f%n", SandwichSize.FOUR_INCH.getBreadPrice()   );
        System.out.printf("2) 8\"  -$%.2f%n", SandwichSize.EIGHT_INCH.getBreadPrice()  );
        System.out.printf("3) 12\"  -$%.2f%n", SandwichSize.TWELVE_INCH.getBreadPrice()   );
        System.out.println("-------------------");
        SandwichSize size = switch (scanner.nextInt()) {
            case 1 -> SandwichSize.FOUR_INCH;
            case 2 -> SandwichSize.EIGHT_INCH;
            case 3 -> SandwichSize.TWELVE_INCH;
            default -> throw new IllegalArgumentException("Invalid");
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
            default -> throw new IllegalArgumentException("Invalid");
        };
        scanner.nextLine();

        Sandwich sandwich = new Sandwich(size, bread);
        addToppings(sandwich);
        System.out.println("Would you like the sandwich toasted? (y/n): ");

        sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("y"));
        System.out.println("Order made: Ready for checkout....");

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

            selectToppingsByType("meat", meats, sandwich);
            selectToppingsByType("cheese", cheeses, sandwich);
            selectToppingsByType("toppings", regulars, sandwich);
            selectToppingsByType("sauces", sauces, sandwich);

    }

    private void selectToppingsByType(String label, Topping[] options, Sandwich sandwich) {
        System.out.println("Add " + label);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d) %s%n", i + 1, options[i].getName());
        }

        boolean select = label.equalsIgnoreCase("toppings") || label.equalsIgnoreCase("sauces");

        if (select) {
            System.out.println("Enter topping numbers");
            System.out.print("> ");
            String[] inputs = scanner.nextLine().trim().split("\\s+");

            for (String input : inputs) {
                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + input);
                    continue;
                }

                if (choice == 0) return;
                if (choice < 1 || choice > options.length) {
                    System.out.println("Invalid topping number: " + choice);
                    continue;
                }

                Topping topping = options[choice - 1];
                String extraInput = InputUtils.getYesOrNo("Add extra " + topping.getName() + "?");

                int quantity = 1;
                if (extraInput.equals("y")) {
                    System.out.print("How many extra servings?\n> ");
                    try {
                        int extraServings = Integer.parseInt(scanner.nextLine().trim());
                        quantity += extraServings;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Using default of 1.");
                    }
                }

                sandwich.addTopping(topping, quantity);
            }
        } else {
            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) return;
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid choice.");
                return;
            }

            Topping topping = options[choice - 1];
            String extraInput = InputUtils.getYesOrNo("Add extra " + topping.getName() + "?");

            int quantity = 1;
            if (extraInput.equals("y")) {
                System.out.print("How many extra servings?\n> ");
                try {
                    int extraServings = Integer.parseInt(scanner.nextLine().trim());
                    quantity += extraServings;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Using default of 1.");
                }
            }

            sandwich.addTopping(topping, quantity);
        }
    }


    @Override
    public void addDrink(Order order) {
        System.out.println("Select drink size:");
        System.out.printf("1) Small  - $2.00%n");
        System.out.printf("2) Medium - $2.50%n");
        System.out.printf("3) Large  - $3.00%n");
        System.out.print("> ");
        String size = switch (scanner.nextInt()) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "";
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