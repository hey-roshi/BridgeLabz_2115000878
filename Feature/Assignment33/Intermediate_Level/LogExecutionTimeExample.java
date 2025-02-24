import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {}

class MethodExecution {

    @LogExecutionTime
    public void method1() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void method2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method3() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LogExecutionTimeExample {

    public static void main(String[] args) throws Exception {
        MethodExecution execution = new MethodExecution();
        Method[] methods = MethodExecution.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(execution);
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                System.out.println("Execution time of " + method.getName() + ": " + executionTime + " nanoseconds");
            }
        }
    }
}