import java.util.Scanner;
class Product{
    static double discount=10.0;
    final int productID;
    String productName;
    double price;
    int quantity;
    public Product(int productID, String productName, double price, int quantity){
        this.productID=productID;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;
    }
    static void updateDiscount(double newDiscount){
        discount=newDiscount;
    }
    void displayDetails(){
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
    }
}
public class ShoppingCart{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter product ID: ");
        int productID = scanner.nextInt();
        scanner.nextLine();        
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();       
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        Product product = new Product(productID,productName,price,quantity);
        if(product instanceof Product){
           product.displayDetails();
        }else{
           System.out.println("Not instance of");
        }
    }
}
