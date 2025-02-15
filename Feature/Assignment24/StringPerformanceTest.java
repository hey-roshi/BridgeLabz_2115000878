public class StringPerformanceTest {

    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations

        // **StringBuffer Performance Test**
        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        System.out.println("Time taken by StringBuffer: " + durationBuffer / 1_000_000 + " ms");

        // **StringBuilder Performance Test**
        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuilder: " + durationBuilder / 1_000_000 + " ms");

        // **Comparison Result**
        if (durationBuffer > durationBuilder) {
            System.out.println("StringBuilder is faster by " + (durationBuffer - durationBuilder) / 1_000_000 + " ms");
        } else {
            System.out.println("StringBuffer is faster by " + (durationBuilder - durationBuffer) / 1_000_000 + " ms");
        }
    }
}
