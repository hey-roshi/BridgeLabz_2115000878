import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class TaskManager {

    @ImportantMethod(level = "LOW")
    public void task1() {
        System.out.println("Executing Task 1 (Low Importance)");
    }

    @ImportantMethod(level = "HIGH")
    public void task2() {
        System.out.println("Executing Task 2 (High Importance)");
    }

    public void task3() {
        System.out.println("Executing Task 3 (No Importance)");
    }
}

public class ImportantMethodExample {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Method[] methods = TaskManager.class.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Importance Level: " + annotation.level());
                System.out.println("------");
            }
        }
    }
}