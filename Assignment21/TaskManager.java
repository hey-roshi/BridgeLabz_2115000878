import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;

    public void addTask(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Circular link
            currentTask = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Maintain circular nature
        }
    }

    public void removeTask(int taskId) {
        if (head == null) return;

        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                if (currentTask == temp) {
                    currentTask = head;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ")");
        }
    }

    public void moveToNextTask() {
        if (currentTask != null) {
            currentTask = currentTask.next;
        }
    }

    public void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName + " (Due: " + temp.dueDate + ")");
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskManager {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Complete Project", 1, "2025-02-15");
        scheduler.addTask(2, "Submit Report", 2, "2025-02-10");
        scheduler.addTask(3, "Prepare Presentation", 3, "2025-02-20");
        
        System.out.println("Task List:");
        scheduler.displayTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMoving to Next Task...");
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearching for Priority 2 Tasks:");
        scheduler.searchTaskByPriority(2);

        System.out.println("\nRemoving Task ID 2...");
        scheduler.removeTask(2);
        scheduler.displayTasks();
    }
}
