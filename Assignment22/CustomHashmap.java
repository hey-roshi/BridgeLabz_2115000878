import java.util.LinkedList;

class CustomHashmap<K, V> {
    private static final int SIZE = 10; // Default bucket size
    private LinkedList<Entry<K, V>>[] buckets; // Array of Linked Lists

    // Constructor
    public CustomHashmap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to calculate index
    private int getHash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Insert key-value pair
    public void put(K key, V value) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // Add new entry
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value; // Return value if found
            }
        }
        return null; // Key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        bucket.removeIf(entry -> entry.key.equals(key)); // Remove if key matches
    }

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CustomHashmap<String, Integer> map = new CustomHashmap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        System.out.println("Alice's Age: " + map.get("Alice")); // 25
        map.remove("Alice");
        System.out.println("Alice's Age after removal: " + map.get("Alice")); // null
    }
}

