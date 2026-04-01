package main;

import main.model.ElectronicProduct;
import main.model.FoodProduct;
import main.model.Product;
import main.service.InventorySaver;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vítejte ve skladu");

        ArrayList<Product> inventory = new ArrayList<>();

        Product klavesnice = new ElectronicProduct("Herní klávesnice", 1590.9, 70, 24);
        inventory.add(klavesnice);
        Product mys = new ElectronicProduct("Herní myš", 990.90, 50, 24);
        inventory.add(mys);
        inventory.add(new FoodProduct("Rohlík", 2.5, 100, "2023-12-25"));


        while (true) {
            System.out.println("""
                    Vyber možnost:
                     1) Zobraz akluální stav\s
                     2) Zadej nový produkt\s
                     3) Ukonči app\s
                     4) Aplikovat vánoční slevu na vše\s
                     5) Uložit do souboru\s
                     6) Součet celkové hodnoty skladu\s
                     7) Vypsat produkty nad 1000kč\s
                     Vaše volba:\s""");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Nezadal si číslo");
                scanner.nextLine(); //vyčištění scanneru
            }

            if (choice == 1) {
                for (Product product : inventory) {
                    product.printDetails();
                    System.out.println("---------------");
                }


            } else if (choice == 2) {
                scanner.nextLine();

                System.out.println("Název produktu: ");
                String name = scanner.nextLine();

                System.out.println("Cena produktu: ");
                double price = scanner.nextDouble();

                System.out.println("Počet kusů: ");
                int quantity = scanner.nextInt();

                System.out.println("Záruka (počet měsíců): ");
                int warrantyPeriod = scanner.nextInt();

                inventory.add(new ElectronicProduct(name, price, quantity, warrantyPeriod));


            } else if (choice == 3) {
                System.out.println("Ukončuji aplikaci");
                break;

            } else if (choice == 4) {
                System.out.println("Výše slevy: ");
                double percentage = scanner.nextDouble();

                for (Product product : inventory) {
                    product.applyDiscount(percentage);
                }
                System.out.println("Sleva aplikována");

            } else if (choice == 5) {
                InventorySaver saver = new InventorySaver();
                saver.saveInventory(inventory);
                System.out.println("Stav skladu uložen do souboru");
            } else if (choice == 6) {
                double celkovaHodnota = inventory.stream()
                        .mapToDouble(p -> p.getPrice() * p.getQuantity())
                        .sum();
                System.out.println("Celková hodnota zboží na skladě je " + celkovaHodnota + "kč");
            } else if (choice == 7){
                System.out.println("Produkty dražší než 1000kč: ");
                 inventory.stream()
                        .filter(p -> p.getPrice() > 1000)
                        .forEach(Product::printDetails);
            }

            else {
                System.out.println("Špatný input");
            }
        }

    }
}
