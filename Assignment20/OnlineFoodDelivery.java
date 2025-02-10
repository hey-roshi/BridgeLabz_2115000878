import java.util.*;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}

// Discountable interface
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: 10%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 5; // Additional $5 charge for non-veg items
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: 5%";
    }
}

// Online Food Delivery System
public class OnlineFoodDelivery {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        // Adding food items
        order.add(new VegItem("Salad", 8.0, 2));
        order.add(new NonVegItem("Chicken Burger", 12.0, 1));

        // Processing order
        for (FoodItem item : order) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            double discount = (item instanceof Discountable) ? ((Discountable) item).applyDiscount() : 0;
            double finalPrice = totalPrice - discount;
            System.out.println("Total Price: $" + totalPrice);
            if (item instanceof Discountable) {
                System.out.println(((Discountable) item).getDiscountDetails());
                System.out.println("Discount Applied: $" + discount);
            }
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("------------------------");
        }
    }
}
