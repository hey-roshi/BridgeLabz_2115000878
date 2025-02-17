import java.util.Arrays;
public class SearchComparison {
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }
    public static int binarySearch(int[] data, int target) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == target) {
                return mid; // Target found
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        int target = 500;
        for (int size : datasetSizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = i; // Data is sorted from 0 to size-1
            }
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long linearSearchTime = endTime - startTime;
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;
            System.out.println("Dataset size: " + size);
            System.out.println("Linear Search time: " + linearSearchTime + " ns");
            System.out.println("Binary Search time: " + binarySearchTime + " ns");
            System.out.println();
        }
    }
}
