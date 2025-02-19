import java.util.*;

public class maxValKey{
    public static String findMaxKey(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return null; // Return null if the map is empty
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        // Sample Input
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Finding the key with the highest value
        String maxKey = findMaxKey(inputMap);

        // Output the result
        System.out.println("Key with the highest value: " + maxKey);
    }
}
