import java.util.*;

class stackUsingQueue{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        q1.add(x);
    }

    // Pop operation
    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        
        // Move all but last element to q2
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        
        // Last added element in q1 is the top of the stack
        int popped = q1.poll();
        
        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return popped;
    }

    // Top operation
    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        // Last element is the top of the stack
        int topElement = q1.poll();
        q2.add(topElement); // Put it back into q2

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        // Push elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop and display output
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.top()); // Output: 2
        System.out.println(stack.pop()); // Output: 2
    }
}
