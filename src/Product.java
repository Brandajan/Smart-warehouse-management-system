public abstract class Product implements Discountable{
    private String name;
    private double price;
    private int quantity;

    //konstruktor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void printDetails(){
        System.out.println("Produkt: " + name);
        System.out.println("Cena: " + price);
        System.out.println("Pocet kusů: " + quantity);
        System.out.println("Skladem: " + (quantity > 0));
    }

    public void applyDiscount(double percentage){
        if (percentage > 0){
            this.price = this.price - (this.price * percentage/100);
        }
    }
    //gettery
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    //settery
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        if(price >= 0){
            this.price = price;
        }

    }
    public void setQuantity(int quantity){
        if(quantity >= 0){
            this.quantity = quantity;
        }

    }
}
