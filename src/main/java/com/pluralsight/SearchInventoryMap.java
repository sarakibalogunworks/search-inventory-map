package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {


    public static HashMap<String, Product> inventory =
            new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchAgain = "yes";

        loadInventory();

        while (searchAgain.equalsIgnoreCase("yes")) {
            System.out.println("What product are you interested in? ");
            String productName = scanner.nextLine();

            Product matchedProduct = inventory.get(productName);

            if (matchedProduct == null) {
                System.out.println("We dont carry that product");
            } else {
                System.out.printf("We carry %s and the price is $%.2f",
                        matchedProduct.getName(), matchedProduct.getPrice());
            }

            System.out.println();
            System.out.println("What do you want to search again? ");
            searchAgain = scanner.nextLine();
            System.out.println();
        }
        System.out.println("Thank you for using our inventory system!");


    }

    private static void loadInventory() {
        try {
            FileReader fileReader = new FileReader("inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product = new Product(id, name, price);

                inventory.put(product.getName(), product);

                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException error) {
            System.out.println("Error reading inventory file: " + error.getMessage());
        }
    }

}
