import java.util.*;

public class mergeMap{
    public static Map<String, Integer> mergeTwoMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1); // Copy map1 into result

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.put(entry.getKey(), result.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample Input
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merging the maps
        Map<String, Integer> mergedMap = mergeTwoMaps(map1, map2);

        // Output the result
        System.out.println("Merged Map: " + mergedMap);
    }
}
