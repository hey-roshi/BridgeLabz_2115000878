import java.util.Arrays;
import java.util.Random;

public class sortingComparison{

    // Bubble Sort
    public static void bubbleSort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] data) {
        if (data.length < 2) return;
        int mid = data.length / 2;
        int[] left = Arrays.copyOfRange(data, 0, mid);
        int[] right = Arrays.copyOfRange(data, mid, data.length);
        
        mergeSort(left);
        mergeSort(right);
        
        merge(data, left, right);
    }

    private static void merge(int[] data, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }
        while (i < left.length) {
            data[k++] = left[i++];
        }
        while (j < right.length) {
            data[k++] = right[j++];
        }
    }

    // Quick Sort
    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    private static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                // Swap
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        // Swap the pivot element to its correct position
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        Random rand = new Random();

        // Loop through different dataset sizes
        for (int size : datasetSizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size); // Generate random data
            }

            // Test Bubble Sort
            int[] dataBubble = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            bubbleSort(dataBubble);
            long endTime = System.nanoTime();
            long bubbleSortTime = endTime - startTime;

            // Test Merge Sort
            int[] dataMerge = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(dataMerge);
            endTime = System.nanoTime();
            long mergeSortTime = endTime - startTime;

            // Test Quick Sort
            int[] dataQuick = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(dataQuick, 0, dataQuick.length - 1);
            endTime = System.nanoTime();
            long quickSortTime = endTime - startTime;

            // Output the times
            System.out.println("Dataset size: " + size);
            System.out.println("Bubble Sort time: " + bubbleSortTime / 1_000_000 + " ms");
            System.out.println("Merge Sort time: " + mergeSortTime / 1_000_000 + " ms");
            System.out.println("Quick Sort time: " + quickSortTime / 1_000_000 + " ms");
            System.out.println();
        }
    }
}
