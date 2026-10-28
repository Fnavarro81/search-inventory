package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        System.out.println("We carry the following inventory: ");

        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(1, "Wireless Mouse", 29.99));
        inventory.add(new Product(2, "Mechanical Keyboard", 89.99));
        inventory.add(new Product(3, "UltraWide Monitor", 349.99));
        inventory.add(new Product(4, "USB-C Hub", 19.99));
        inventory.add(new Product(5, "Ergonomic Office Chair", 199.99));

        return inventory;
    }
}
