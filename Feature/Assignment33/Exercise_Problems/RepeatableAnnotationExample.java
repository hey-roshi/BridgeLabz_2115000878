import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class TaskManager {

    @BugReport(description = "Bug 1: Null pointer exception in task1.")
    @BugReport(description = "Bug 2: Task2 performance issue, takes too long.")
    public void task() {
        System.out.println("Executing task with bugs...");
    }
}

public class RepeatableAnnotationExample {

    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getDeclaredMethod("task");
            BugReports bugReports = method.getAnnotation(BugReports.class);
            
            if (bugReports != null) {
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug Description: " + bug.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}