public class ElectronicProduct extends Product {
    private final int warrantyPeriod;
    public ElectronicProduct(String name, double price, int quantity, int warrantyPeriod) {
        super(name, price, quantity);
        this.warrantyPeriod = warrantyPeriod;
    }
        @Override
        public void printDetails(){
            super.printDetails();
            System.out.println("Záruka: " + warrantyPeriod);
        }
    }

