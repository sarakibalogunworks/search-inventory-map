package com.pluralsight;

import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {


    public static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();


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
                System.out.println("We carry %s and the price is $%.2f%n",
                        matchedProduct.getName(), matchedProduct.getPrice());
            }

            System.out.println();
            System.out.println("What do you want to search again? ");
            searchAgain = scanner.nextLine();
            System.out.println();
        }
        System.out.println("Thank you for using our inventory system!");


    }

    private st

}
