import java.util.Scanner;

class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryLinkedList {
    private ItemNode head;

    public void addItem(String itemName, int itemId, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public ItemNode searchItem(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void displayInventory() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }
}

public class InventoryMagtSystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addItem("Laptop", 101, 10, 750.00);
        inventory.addItem("Phone", 102, 20, 500.00);
        inventory.addItem("Tablet", 103, 15, 300.00);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        System.out.println("\nUpdating Quantity for Item ID 102...");
        inventory.updateQuantity(102, 25);
        inventory.displayInventory();

        System.out.println("\nRemoving Item ID 101...");
        inventory.removeItem(101);
        inventory.displayInventory();

        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());
    }
}
