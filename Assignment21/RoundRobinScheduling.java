import java.util.Scanner;

class Process {
    int processId, burstTime, remainingTime;
    Process next;

    public Process(int processId, int burstTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;

    public void addProcess(int processId, int burstTime) {
        Process newProcess = new Process(processId, burstTime);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Circular link
        }
    }

    public void executeProcesses(int timeQuantum) {
        if (head == null) return;

        Process current = head;
        int time = 0, totalWaitingTime = 0, totalTurnaroundTime = 0, completedProcesses = 0;
        int processCount = getProcessCount();

        while (completedProcesses < processCount) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                time += execTime;
                current.remainingTime -= execTime;

                if (current.remainingTime == 0) {
                    completedProcesses++;
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;
                    System.out.println("Process " + current.processId + " completed at time " + time);
                }
            }
            current = current.next; // Move to next process
        }

        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
    }

    public int getProcessCount() {
        if (head == null) return 0;
        Process temp = head;
        int count = 0;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Processes in the queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 5);
        scheduler.addProcess(2, 8);
        scheduler.addProcess(3, 3);
        scheduler.addProcess(4, 6);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        System.out.print("\nEnter Time Quantum: ");
        int timeQuantum = scanner.nextInt();
        scheduler.executeProcesses(timeQuantum);
    }
}
