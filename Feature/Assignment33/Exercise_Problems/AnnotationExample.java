import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation @TaskInfo
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Apply the annotation in TaskManager class
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Muskan")
    public void task1() {
        System.out.println("Executing Task 1");
    }

    @TaskInfo(priority = "Low", assignedTo = "Mansi")
    public void task2() {
        System.out.println("Executing Task 2");
    }
}

// Step 3: Retrieve annotation details using Reflection API
public class AnnotationExample {

    public static void main(String[] args) {
        // Create TaskManager instance
        TaskManager manager = new TaskManager();
        
        // Retrieve and process methods with @TaskInfo annotation
        Method[] methods = TaskManager.class.getDeclaredMethods();
        for (Method method : methods) {
            // Check if the method has @TaskInfo annotation
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            if (taskInfo != null) {
                // Display task details if annotation is present
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned to: " + taskInfo.assignedTo());
                System.out.println("------");
            }
        }
    }
}
