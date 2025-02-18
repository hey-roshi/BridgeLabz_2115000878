import java.util.*;
class Category{
    private String name;
    public Category(String name){
        this.name = name;
    }
    public String getCategoryName(){
        return name;
    }
}
class BookCategory extends Category{
    public BookCategory(){
        super("Book");
    }
}
class ClothingCategory extends Category{
    public ClothingCategory(){
        super("Clothing");
    }
}
class GadgetCategory extends Category{
    public GadgetCategory(){
        super("Gadget");
    }
}
class Product<T extends Category>{
    private String name;
    private double price;
    private T category;
    public Product(String name,double price,T category){
        this.name=name;
        this.price=price;
        this.category=category;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public T getCategory(){
        return category;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void displayDetails(){
        System.out.println(name + " | $" + price + " | Category: " + category.getCategoryName());
    }
}
class DiscountManager{
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Applied " + percentage + "% discount on " + product.getName());
    }
}
class Marketplace {
    private List<Product<?>> productCatalog = new ArrayList<>();
    public void addProduct(Product<?> product) {
        productCatalog.add(product);
    }
    public void displayCatalog(){
        System.out.println("\nMarketplace Product Catalog:");
        for (Product<?> product : productCatalog) {
            product.displayDetails();
        }
    }
}
public class dynamicMarketplace{
    public static void main(String[] args){
        // Create category instances
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();

        // Create product instances
        Product<BookCategory> book1 = new Product<>("The Alchemist", 20.0, bookCategory);
        Product<ClothingCategory> tshirt = new Product<>("Graphic T-Shirt", 15.0, clothingCategory);
        Product<GadgetCategory> phone = new Product<>("iPhone 14", 999.0, gadgetCategory);

        // Create Marketplace and Add Products
        Marketplace marketplace = new Marketplace();
        marketplace.addProduct(book1);
        marketplace.addProduct(tshirt);
        marketplace.addProduct(phone);

        // Display Products Before Discount
        marketplace.displayCatalog();

        // Apply Discounts
        DiscountManager.applyDiscount(book1, 10); // 10% discount
        DiscountManager.applyDiscount(phone, 5);  // 5% discount

        // Display Products After Discount
        marketplace.displayCatalog();
    }
}

