package utils;

import java.util.Scanner;

public class InputUtils {
    private  static final Scanner scanner = new Scanner(System.in);

    public static String getYesOrNo(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (y/n): ");
            input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("n")) {
                return input;
            }
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }
}
