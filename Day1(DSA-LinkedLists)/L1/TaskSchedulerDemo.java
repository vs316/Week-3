package DSA.LinkedLists;

// A node representing a task in the circular linked list.
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// TaskScheduler implements a circular linked list of tasks.
class TaskScheduler {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode current;  // tracks the current task for viewing and iteration

    public TaskScheduler() {
        head = null;
        tail = null;
        current = null;
    }

    // Add a task at the beginning.
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) { // empty list
            head = newNode;
            tail = newNode;
            newNode.next = head; // circular link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // update tail pointer to maintain circularity
        }
        if (current == null) current = head;
        System.out.println("Added task at beginning: " + taskName);
    }

    // Add a task at the end.
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) { // empty list
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        if (current == null) current = head;
        System.out.println("Added task at end: " + taskName);
    }

    // Add a task at a specific 1-based position.
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        int count = 1;
        // Traverse until the node after which we will insert the new node.
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        // Insert the new node after temp.
        newNode.next = temp.next;
        temp.next = newNode;
        // If new node is added after tail, update tail pointer.
        if (temp == tail) {
            tail = newNode;
        }
        tail.next = head;
        System.out.println("Added task at position " + position + ": " + taskName);
    }

    // Remove a task by its Task ID.
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        TaskNode temp = head;
        TaskNode prev = tail; // Because list is circular, previous of head is tail.
        boolean found = false;

        do {
            if (temp.taskId == taskId) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task not found with ID: " + taskId);
            return;
        }

        // If the list has only one node.
        if (temp == head && head.next == head) {
            head = null;
            tail = null;
            current = null;
        } else {
            // Removing the head.
            if (temp == head) {
                head = head.next;
                tail.next = head;
            }
            // Removing the tail.
            else if (temp == tail) {
                tail = prev;
                tail.next = head;
            }
            // Removing a node from the middle.
            else {
                prev.next = temp.next;
            }
            // If current points to the removed node, move it to next.
            if (current == temp) {
                current = temp.next;
            }
        }
        System.out.println("Removed task with ID: " + taskId);
    }

    // View the current task.
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No current task available.");
        } else {
            System.out.println("Current task => Task ID: " + current.taskId + ", Task Name: " + current.taskName
                    + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
        }
    }

    // Move the current pointer to the next task in the circular list.
    public void moveToNextTask() {
        if (current == null) {
            System.out.println("No tasks in the scheduler.");
        } else {
            current = current.next;
            viewCurrentTask();
        }
    }

    // Display all tasks starting from the head node.
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        System.out.println("Displaying all tasks:");
        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by a given priority.
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        boolean found = false;
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found task => Task ID: " + temp.taskId + ", Task Name: " + temp.taskName +
                        ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}

public class TaskSchedulerDemo {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks using various insertion methods.
        scheduler.addTaskAtEnd(1, "Task One", 3, "2023-11-01");
        scheduler.addTaskAtBeginning(2, "Task Two", 2, "2023-10-15");
        scheduler.addTaskAtPosition(3, "Task Three", 1, "2023-12-22", 2);
        scheduler.addTaskAtEnd(4, "Task Four", 3, "2023-11-30");

        // Display all tasks in the circular list.
        System.out.println("\n--- All Tasks ---");
        scheduler.displayAllTasks();

        // View the current task and then move to the next one.
        System.out.println("\n--- Current Task and Moving Forward ---");
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.moveToNextTask();

        // Remove a task by Task ID.
        System.out.println("\n--- Removing Task with ID 3 ---");
        scheduler.removeTaskById(3);  // Removes "Task Three"
        scheduler.displayAllTasks();

        // Search for tasks by priority.
        System.out.println("\n--- Searching Tasks with Priority 3 ---");
        scheduler.searchTaskByPriority(3);
    }
}