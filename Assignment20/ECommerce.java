import java.util.*;
abstract class Product{
     private int prodId;
     private String name;
     private int price;
     public abstract double calculateDiscount();
     public Product(int prodId, String name,int price){
          this.prodId=prodId;
          this.name=name;
          this.price=price;
     }
     public int getProdId(){
          return prodId;
     }
     public String getName(){
          return name;
     }
     public int getPrice(){
          return price;
     } 
     public void setProdId(int prodId){
        this.prodId=prodId;
     }
     public void setName(String name){
        this.name=name;
     }
     public void setPrice(int price){
         this.price=price;
     }
     public void displayDetails() {
        System.out.println("Product ID: " + prodId);
        System.out.println("Product Name: " + name);
        System.out.println("Base Price: $" + price);
     }
}
interface Taxable{
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable{
     public Electronics(int prodId,String name,int price){
          super(prodId,name,price);
     }
     public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }
    public double calculateTax() {
        return getPrice() * 0.15; // 15% tax
    }
    public String getTaxDetails() {
        return "Electronics Tax: 15%";
    }

}
class Clothing extends Product implements Taxable{
        public Clothing(int prodId,String name,int price){
          super(prodId,name,price);
        }
        public double calculateDiscount() {
           return getPrice() * 0.20; // 20% discount
        }
        public double calculateTax() {
           return getPrice() * 0.05; // 5% tax
        }
        public String getTaxDetails() {
           return "Clothing Tax: 5%";
        }
}

class Groceries extends Product{
        public Groceries(int prodId,String name,int price){
           super(prodId,name,price);
        }
        public double calculateDiscount() {
          return getPrice() * 0.05; // 5% discount
        }
}
public class ECommerce{
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        // Adding products
        products.add(new Electronics(101, "Laptop", 1200));
        products.add(new Clothing(201, "T-Shirt", 50));
        products.add(new Groceries(301, "Apples", 10));

        // Display product details and final price
        for (Product product : products) {
           product.displayDetails();
           if (product instanceof Taxable){
            double discount = product.calculateDiscount();
            double tax=((Taxable) product).calculateTax();
            double finalPrice = product.getPrice() - discount + tax;
            System.out.println("Discount: $" + discount);
            System.out.println(((Taxable) product).getTaxDetails());
            System.out.println("Tax: $" + tax);
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("------------------------");
           }
        }
    }
}
