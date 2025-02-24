import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@interface TaskInfo {
    String priority();
    String assignedTo();
}
class TaskManager{
    @TaskInfo(priority="High",assignedTo="Muskan")
    public void task1(){
        System.out.println("Executing Task 1");
    }
    @TaskInfo(priority = "Low", assignedTo = "Mansi")
    public void task2(){
        System.out.println("Executing Task 2");
    }
}
public class annotationExample{
    public static void main(String[] args){
        TaskManager manager=new TaskManager();
        Method[] methods=TaskManager.class.getDeclaredMethods();
        for(Method method:methods){
            TaskInfo taskInfo=method.getAnnotation(TaskInfo.class);
            if(taskInfo!=null){
                // Display task details if annotation is present
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned to: " + taskInfo.assignedTo());
                System.out.println("------");
            }
        }
    }
}
