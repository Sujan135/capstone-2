package com.pluralsight;

import models.Order;

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
                    order.addSandwich("Sample sandwich");
                    System.out.println("Added sandwich.");
                    break;

                case 2:
                    order.addDrink("Sample Drink");
                    System.out.println("Added drink");
                    break;

                case 3:
                    order.addChips("Sample chips");
                    System.out.println("Added chips");
                    break;

                case 4:
                    System.out.println("Checkout selected.");
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
