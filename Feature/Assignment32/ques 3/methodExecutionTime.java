import java.lang.reflect.Method;

class ExecutionTimeLogger {

    public static void logExecutionTime(Object target, String methodName, Class<?>[] parameterTypes, Object[] parameters) {
        try {
            Method method = target.getClass().getMethod(methodName, parameterTypes);
            long startTime = System.nanoTime();
            method.setAccessible(true);
            method.invoke(target, parameters);
            long endTime = System.nanoTime();
            System.out.println("Execution time of method " + methodName + ": " + (endTime - startTime) + " nanoseconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExampleClass {

    public void method1() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Method 1 executed");
    }

    public void method2(int a, int b) {
        System.out.println("Method 2 executed, sum: " + (a + b));
    }
}

public class methodExecutionTime {
    public static void main(String[] args) {
        ExampleClass example = new ExampleClass();

        ExecutionTimeLogger.logExecutionTime(example, "method1", new Class[]{}, new Object[]{});
        ExecutionTimeLogger.logExecutionTime(example, "method2", new Class[]{int.class, int.class}, new Object[]{5, 10});
    }
}
