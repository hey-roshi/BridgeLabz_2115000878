import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectManager {

    @Todo(task = "Implement user login", assignedTo = "Muskan", priority = "HIGH")
    public void feature1() {
        System.out.println("Feature 1 (Login) is pending.");
    }

    @Todo(task = "Add profile picture upload", assignedTo = "Shreya", priority = "LOW")
    public void feature2() {
        System.out.println("Feature 2 (Profile Picture Upload) is pending.");
    }

    @Todo(task = "Integrate payment gateway", assignedTo = "Mansi")
    public void feature3() {
        System.out.println("Feature 3 (Payment Gateway Integration) is pending.");
    }

    public void completedFeature() {
        System.out.println("This feature is completed.");
    }
}

public class TodoAnnotationExample {

    public static void main(String[] args) {
        ProjectManager manager = new ProjectManager();
        Method[] methods = ProjectManager.class.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Pending Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("------");
            }
        }
    }
}