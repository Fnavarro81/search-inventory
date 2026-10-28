package com.pluralsight;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory: ");

        displayInventory(inventory);
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        String filePath = "inventory.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (parseProductLine(line, inventory)) continue;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the inventory file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("An error occurred while parsing a product price: " + e.getMessage());
        }

        return inventory;
    }

    private static boolean parseProductLine(String line, ArrayList<Product> inventory) {
        if (line.trim().isEmpty()) {
            return true;
        }

        String[] parts = line.split("\\|");

        if (parts.length >= 3) {
            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            double price = Double.parseDouble(parts[2].trim());

            inventory.add(new Product(id, name, price));
        }
        return false;
    }

    private static void displayInventory(ArrayList<Product> inventory) {
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(),
                    p.getName(),
                    p.getPrice());
        }
    }
}
