import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();  // Stores product prices
    private Map<String, Integer> cart = new LinkedHashMap<>();    // Maintains order of added items

    // Add a product with its price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    // Get total price of cart
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    // Get items sorted by price
    public Map<String, Double> getItemsSortedByPrice() {
        TreeMap<Double, String> sortedMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            sortedMap.put(productPrices.get(entry.getKey()), entry.getKey());
        }

        // Convert back to a LinkedHashMap (sorted by price)
        Map<String, Double> sortedCart = new LinkedHashMap<>();
        for (Map.Entry<Double, String> entry : sortedMap.entrySet()) {
            sortedCart.put(entry.getValue(), entry.getKey());
        }
        return sortedCart;
    }

    // Display cart items
    public void displayCart() {
        System.out.println("\nCart Items (In Order Added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - Quantity: " + entry.getValue() +
                    ", Price: " + productPrices.get(entry.getKey()));
        }
    }

    // Display sorted items
    public void displaySortedItems() {
        System.out.println("\nItems Sorted by Price:");
        for (Map.Entry<String, Double> entry : getItemsSortedByPrice().entrySet()) {
            System.out.println(entry.getKey() + " - Price: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products with prices
        cart.addProduct("Laptop", 800.00);
        cart.addProduct("Phone", 500.00);
        cart.addProduct("Tablet", 300.00);
        cart.addProduct("Headphones", 100.00);
    }
}
