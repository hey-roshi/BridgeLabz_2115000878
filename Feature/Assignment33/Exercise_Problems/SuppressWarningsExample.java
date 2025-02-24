import java.util.ArrayList;

public class SuppressWarningsExample {

    @SuppressWarnings("unchecked") // Suppresses unchecked warnings
    public static void main(String[] args) {
        // Using a raw type ArrayList (not recommended, but for demonstration)
        ArrayList rawList = new ArrayList();
        
        rawList.add("Java");
        rawList.add("Python");
        rawList.add("C++");

        // Type-safe conversion (Recommended approach)
        ArrayList<String> safeList = new ArrayList<>(rawList); 

        System.out.println("Safe List: " + safeList);
    }
}