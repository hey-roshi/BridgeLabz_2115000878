import java.util.*;
public class searchComparison{
    public static void main(String[] args) {
        int N = 1_000_000; // Change dataset size for testing
        Random rand = new Random();
        int target = rand.nextInt(N);
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<N;i++){
            int num = rand.nextInt(N * 10); 
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }
        long startArray = System.nanoTime();
        boolean foundArray = linearSearch(array, target);
        long endArray = System.nanoTime();
        System.out.println("Array Search (O(N)): " + (endArray - startArray) / 1_000_000.0 + " ms");
        long startHashSet = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet Search (O(1)): " + (endHashSet - startHashSet) / 1_000_000.0 + " ms");

        long startTreeSet = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet Search (O(log N)): " + (endTreeSet - startTreeSet) / 1_000_000.0 + " ms");
    }
    private static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
