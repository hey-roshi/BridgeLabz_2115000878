import java.util.LinkedList;

public class FindNthFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return "Invalid Input";
        }

        // Two-pointer approach
        int first = 0;
        int second = 0;

        // Move the first pointer N steps ahead
        while (first < n) {
            if (first >= list.size()) {
                return "N is larger than the list size"; // Edge case
            }
            first++;
        }

        // Move both pointers one step at a time
        while (first < list.size()) {
            first++;
            second++;
        }

        return list.get(second);
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        System.out.println("Nth element from the end: " + findNthFromEnd(list, n));
    }
}
