package manager;

import models.*;

import java.util.Scanner;

public class OrderScreen {
    private Order order;
    private Scanner scanner;

    public OrderScreen(Order order, Scanner scanner) {
        this.order = order;
        this.scanner = scanner;
    }

    public void show() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nOrder Screen");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Choose an option: ");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    Sandwich sandwich = new AddSandwichScreen(scanner).createSandwich();
                    order.addItem(sandwich);
                    System.out.println("Added sandwich");
                    break;

                case 2:
                    Drink drink = new AddDrinkScreen(scanner).createDrink();
                    order.addItem(drink);
                    System.out.println("Added drink");
                    break;

                case 3:
                    Chips chips = new AddChipsScreen(scanner).createChips();
                    order.addItem(chips);
                    System.out.println("Added chips");
                    break;

                case 4:
                    System.out.println("Checkout selected.");
                    for (OrderItem item : order.getItems()) {
                        System.out.println(item.getDescription() + "- $" +
                                String.format("%.2f", item.getPrice()));
                    }
                    System.out.println("Total: $" + String.format("%.2f", order.getTotalPrice()));
                    System.out.println("Confirm order? (yes/no): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")){
                        System.out.println("order confirmed");
                    } else {
                        System.out.println("order canceled");
                    }
                    ordering = false;
                    break;

                case 0:
                    System.out.println("Order canceled.");
                    order.clear();
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }



        }
    }
}
