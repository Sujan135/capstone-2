package com.pluralsight;

import manager.ApplicationManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Deli Sandwich Shop!");
        ApplicationManager manager = new ApplicationManager();
        manager.startApplication();

        System.out.println("Thank you for visiting! Goodbye. ");
    }
}