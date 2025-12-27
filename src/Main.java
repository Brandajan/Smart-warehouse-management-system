import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Vítejte ve skladu");

        ArrayList<Product> inventory = new ArrayList<>();

        Product klavesnice = new ElectronicProduct("Herní klávesnice", 1590.9, 70, 24);
        inventory.add(klavesnice);
        Product mys = new ElectronicProduct("Herní myš", 990.90,50,24);
        inventory.add(mys);
        inventory.add(new FoodProduct("Rohlík", 2.5, 100, "2023-12-25"));


        while(true){
            System.out.println("Vyber možnost:\n 1) zobraz akluální stav \n 2) zadej nový produkt \n 3) ukonči app \n 4) Aplikovat vánoční slevu na vše \n Vaše volba: ");
            int choice = scanner.nextInt();
            if(choice == 1){
                for(Product product : inventory){
                    product.printDetails();
                    System.out.println("---------------");
                }


            } else if(choice == 2){
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


            } else if(choice == 3) {
                System.out.println("Ukončuji aplikaci");
                break;

            } else if (choice == 4) {
                System.out.println("Výše slevy: ");
                double percentage = scanner.nextDouble();

                for(Product product : inventory){
                    product.applyDiscount(percentage);
                }
                System.out.println("Sleva aplikována");

            } else {
                System.out.println("Špatný input");
            }
        }

    }
}
