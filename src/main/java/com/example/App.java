package com.example;

import com.example.CountryService;

import java.util.Scanner;

/**
 * Main class for the Country Management System.
 * Allows users to add, view, update, and remove countries.
 */
public class App {
    public static void main(String[] args) {
        CountryService countryService = new CountryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** Welcome to the Country Management System ***");
            System.out.println("Please choose one of the following options:");
            System.out.println("-------------------------------------------------");
            System.out.println("1. Add a new country");
            System.out.println("2. View country details");
            System.out.println("3. Update country population");
            System.out.println("4. Remove a country");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------------------");
            System.out.print("Your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the country you want to add:");
                    String createName = scanner.nextLine();
                    System.out.println("Enter the population of the country:");
                 
                    Long createPopulation = scanner.nextLong();
                    scanner.nextLine();
                    countryService.createCountry(createName, createPopulation);
                    break;

                case 2:
                    System.out.println("Enter the name of the country you want to view:");
                    String readName = scanner.nextLine();
                    countryService.readCountry(readName);
                    break;

                case 3:
                    System.out.println("Enter the name of the country you want to update:");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter the new population for " + updateName + ":");
                    Long updatePopulation = scanner.nextLong();
                    countryService.updateCountry(updateName, updatePopulation);
                    break;

                case 4:
                    System.out.println("Enter the name of the country you want to remove:");
                    String deleteName = scanner.nextLine();
                    countryService.deleteCountry(deleteName);
                    break;

                case 5:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 5.");
            }

            // Ask user if they want to perform another action after any operation
            System.out.print("\nWould you like to perform another action? (yes/no): ");
            String continueChoice = scanner.nextLine().toLowerCase();

            if (!continueChoice.equals("yes")) {
                System.out.println("Thank you for using Country Management System. Goodbye!");
                break;
            }
        }
    }
}
