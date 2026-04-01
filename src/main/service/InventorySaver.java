package main.service;

import main.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class InventorySaver {
    public void saveInventory(ArrayList<Product> inventory){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sklad.txt"))){
            for (Product product : inventory){
                writer.write( product.getName() + ", " + product.getPrice() + ", " + product.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
