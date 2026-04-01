public class ProductTest {
    public static void main(String[] args) {
        testApplyDiscount();
    }
    public static void testApplyDiscount(){
        Product klavesnice = new ElectronicProduct("klávesnice", 2000.0, 1, 6);
        klavesnice.applyDiscount(10);
        if (klavesnice.getPrice() == 1800.0){
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }
}
