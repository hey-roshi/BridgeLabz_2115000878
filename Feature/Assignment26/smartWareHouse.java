import java.util.*;
abstract class WarehouseItem{
      private String name;
      public WarehouseItem(String name){
          this.name=name;
      }
      public String getName(){
          return name;
      }
      public abstract void displayDetails();
}
class Electronics extends WarehouseItem{
      private String brand;
      public Electronics(String name, String brand){
          super(name);
          this.brand=brand;
      }
      public void displayDetails(){
          System.out.println("Brand name is "+brand);
      }
}
class Groceries extends WarehouseItem{
      private String date;
      public Groceries(String name,String date){
          super(name);
          this.date=date;
      }
      public void displayDetails(){
          System.out.println("Date is "+date);
      }
}
class Furniture extends WarehouseItem{
      private String Material;
      public Furniture(String name,String Material){
          super(name);
          this.Material=Material;
      }
      public void displayDetails(){
          System.out.println("Material is "+Material);
      }
}
class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public void displayItems(List<? extends WarehouseItem> itemList) {
        for (WarehouseItem item : itemList) {
            item.displayDetails();
        }
    }
    public List<T> getItems() {
        return items;
    }
}
public class smartWareHouse{
    public static void main(String[] args) {
        Electronics laptop = new Electronics("Laptop", "Dell");
        Groceries apple = new Groceries("Apple", "2025-12-01");
        Furniture chair = new Furniture("Chair", "Wood");

        // Create storage for each item type
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to the respective storages
        electronicsStorage.addItem(laptop);
        groceriesStorage.addItem(apple);
        furnitureStorage.addItem(chair);

        // Display items from each storage using the wildcard method
        System.out.println("Displaying Electronics:");
        electronicsStorage.displayItems(electronicsStorage.getItems());

        System.out.println("\nDisplaying Groceries:");
        groceriesStorage.displayItems(groceriesStorage.getItems());

        System.out.println("\nDisplaying Furniture:");
        furnitureStorage.displayItems(furnitureStorage.getItems());
    }
}
