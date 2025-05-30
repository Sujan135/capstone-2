package manager;

import models.Order;
import services.OrderService;
import services.OrderServiceImpl;

import java.util.Scanner;

public class ApplicationManager {
    private final OrderService orderService;
    private final Scanner scanner;

    public ApplicationManager() {
        this.orderService = new OrderServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void startApplication() {
        while (true) {
            System.out.println("DELI-cious Home Screen");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                handleNewOrder();
            } else if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid Input.");
            }
        }
    }

    private void handleNewOrder() {
        Order order = orderService.createOrder();
        while (true) {
            System.out.println("Order Screen");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    orderService.addSandwich(order);
                    break;
                case 2:
                    orderService.addDrink(order);
                    break;
                case 3:
                    orderService.addChips(order);
                    break;
                case 4:
                    orderService.checkout(order);
                    return;
                case 0:
                    orderService.cancelOrder(order);
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}