public class FoodProduct extends Product {
    private final String expirationDate;
    public FoodProduct(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }
       @Override
       public void printDetails(){
       super.printDetails();
       System.out.println("Trvanlivost: " + expirationDate);
    }
}