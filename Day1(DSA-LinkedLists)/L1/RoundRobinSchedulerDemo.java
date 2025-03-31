package DSA.LinkedLists;

// Process node representing a process in the scheduler
class ProcessNode {
    int processId;
    int burstTime;      // original burst time
    int remainingTime;  // time left to complete the process
    int priority;       // not used directly for round-robin, but stored
    ProcessNode next;   // pointer to next process

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // initially, remaining time equals burst time
        this.priority = priority;
        this.next = null;
    }
}

// Round-robin scheduler using a circular linked list
class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;
    private ProcessNode current;  // points to the process being executed

    public RoundRobinScheduler() {
        head = null;
        tail = null;
        current = null;
    }

    // Add a process at the end of the circular list.
    public void addProcessAtEnd(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) { // If the list is empty
            head = newNode;
            tail = newNode;
            newNode.next = head; // circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // maintain circularity
        }
        // If no process is being executed yet, start at the head.
        if (current == null) {
            current = head;
        }
        System.out.println("Added Process ID: " + processId + " | Burst: " + burstTime + " | Priority: " + priority);
    }

    // Utility method: Display the list of processes (showing their remaining times).
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the scheduler.");
            return;
        }
        System.out.println("Current Process Queue:");
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " | Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Helper method: Given a node, find its previous node in this circular list.
    private ProcessNode getPrevious(ProcessNode node) {
        if (head == null || node == head) {
            return tail; // for head the previous is tail
        }
        ProcessNode temp = head;
        while (temp.next != node) {
            temp = temp.next;
        }
        return temp;
    }

    // Remove a process node from the circular list, given its previous node.
    private void removeProcess(ProcessNode processToRemove, ProcessNode prev) {
        // Single-node case.
        if (processToRemove == head && processToRemove == tail) {
            head = null;
            tail = null;
            current = null;
        } else if (processToRemove == head) { // Removing head.
            head = head.next;
            tail.next = head;
        } else if (processToRemove == tail) { // Removing tail.
            tail = prev;
            tail.next = head;
        } else { // Removing from the middle.
            prev.next = processToRemove.next;
        }
    }

    // Simulate round-robin scheduling with a fixed time quantum.
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        int currentTime = 0;
        double totalTurnaroundTime = 0;
        double totalWaitingTime = 0;
        int completedProcesses = 0;

        System.out.println("\n--- Starting Round Robin Scheduling ---");
        // Loop until the process list becomes empty.
        while (head != null) {
            ProcessNode p = current; // process to execute
            // Get the previous node of current (needed for removal if finished)
            ProcessNode prev = getPrevious(p);

            if (p.remainingTime > 0) {
                if (p.remainingTime > timeQuantum) {
                    // Process uses a full time quantum.
                    System.out.println("Process " + p.processId + " executes for " + timeQuantum + " time units.");
                    p.remainingTime -= timeQuantum;
                    currentTime += timeQuantum;
                } else {
                    // Process finishes execution.
                    System.out.println("Process " + p.processId + " executes for " + p.remainingTime + " time units and finishes.");
                    currentTime += p.remainingTime;
                    int turnaround = currentTime;
                    int waiting = turnaround - p.burstTime;
                    totalTurnaroundTime += turnaround;
                    totalWaitingTime += waiting;
                    completedProcesses++;
                    // Remove the finished process before moving on.
                    // If the finished process is the current process, move current pointer first.
                    current = p.next;
                    removeProcess(p, prev);
                    // If the list becomes empty, exit the loop.
                    if (head == null) {
                        break;
                    }
                    // Display the current process queue after removal.
                    displayProcesses();
                    // Continue directly to the next iteration.
                    continue;
                }
            }
            // Move to next process.
            current = current.next;
            // Display the process queue after each execution round.
            displayProcesses();
        }
        double avgTurnaround = totalTurnaroundTime / completedProcesses;
        double avgWaiting = totalWaitingTime / completedProcesses;
        System.out.println("--- Scheduling Completed ---");
        System.out.println("Average Turnaround Time: " + avgTurnaround);
        System.out.println("Average Waiting Time: " + avgWaiting);
    }
}

// Main class demonstrating the round-robin scheduling.
public class RoundRobinSchedulerDemo {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding sample processes (processId, burstTime, priority)
        scheduler.addProcessAtEnd(1, 10, 3);
        scheduler.addProcessAtEnd(2, 5, 2);
        scheduler.addProcessAtEnd(3, 8, 1);

        System.out.println("\nInitial Process Queue:");
        scheduler.displayProcesses();

        // Set a time quantum (e.g., 4 time units)
        int timeQuantum = 4;
        System.out.println("Simulating Round Robin Scheduling with Time Quantum: " + timeQuantum);

        // Run the scheduler simulation
        scheduler.simulateRoundRobin(timeQuantum);
    }
}