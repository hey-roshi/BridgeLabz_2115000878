class circularBuffer{
    private int[] buffer;
    private int head = 0, tail = 0, size = 0, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Insert element into the buffer
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity; // Move tail forward
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Overwrite the oldest element
        }
    }

    // Display the buffer contents
    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // Output: Buffer: 1 2 3
        
        cb.insert(4);
        cb.display(); // Output: Buffer: 2 3 4
        
        cb.insert(5);
        cb.display(); // Output: Buffer: 3 4 5
    }
}
