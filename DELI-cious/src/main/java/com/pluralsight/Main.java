package com.pluralsight;

import models.Order;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int input = scanner.nextInt();

            switch(input) {
                case 1:
                    Order order = new Order();
                    OrderScreen orderScreen = new OrderScreen(order, scanner);
                    orderScreen.show();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
    }
}
