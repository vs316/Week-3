package DSA.LinkedLists;

// Node for the doubly linked list representing a text state
class TextStateNode {
    String text;
    TextStateNode next;
    TextStateNode prev;

    public TextStateNode(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

// Manager for the undo/redo history using a doubly linked list
class UndoRedoManager {
    private TextStateNode head;       // Points to the oldest state
    private TextStateNode tail;       // Points to the most recent state
    private TextStateNode current;    // Points to the current state
    private final int capacity;       // Fixed capacity (e.g., 10 states)
    private int size;                 // Current number of states in history

    // Constructor to set the maximum number of states (capacity)
    public UndoRedoManager(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    // Add a new state (called when the user types or performs an action)
    public void addState(String text) {
        // If we are not at the end, discard the redo history.
        if (current != tail) {
            if (current != null) {
                current.next = null;
                tail = current;
            }
        }

        // Create the new state node
        TextStateNode newNode = new TextStateNode(text);
        if (head == null) { // List is empty
            head = newNode;
            tail = newNode;
            current = newNode;
            size = 1;
        } else {
            // Append the new state at the tail
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = newNode;
            size++;
        }

        // If we exceed capacity, remove the oldest state (from the head)
        if (size > capacity) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        }
    }

    // Undo: Move current pointer to the previous state if available
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed. Current state: " + current.text);
        } else {
            System.out.println("No more undo states available.");
        }
    }

    // Redo: Move current pointer to the next state if available
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed. Current state: " + current.text);
        } else {
            System.out.println("No more redo states available.");
        }
    }

    // Return the current state text
    public String getCurrentState() {
        return current != null ? current.text : "";
    }

    // For debugging or display purposes, print history from oldest to newest.
    public void printHistory() {
        TextStateNode temp = head;
        System.out.println("History (oldest -> newest):");
        while (temp != null) {
            String marker = (temp == current) ? " <== current" : "";
            System.out.println(temp.text + marker);
            temp = temp.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate undo/redo functionality for a text editor.
public class TextEditorUndoRedo {
    public static void main(String[] args) {
        // Create the undo/redo manager with fixed capacity 10
        UndoRedoManager manager = new UndoRedoManager(10);

        // Simulate user actions by adding different text states:
        manager.addState("Hello");
        manager.addState("Hello, world!");
        manager.addState("Hello, world! This is a text editor.");
        manager.printHistory();

        // Perform two undo operations:
        manager.undo(); // Reverts to "Hello, world!"
        manager.undo(); // Reverts to "Hello"
        manager.printHistory();

        // Perform a redo operation:
        manager.redo(); // Goes to "Hello, world!"
        manager.printHistory();

        // After an undo, if a new state is added, redo history is cleared.
        manager.undo(); // Revert back to "Hello"
        manager.addState("Hi there!"); // New state added; any redo state is discarded.
        manager.printHistory();

        // Demonstrate further undo/redo
        manager.undo(); // Should bring us back to "Hello"
        manager.undo(); // May print that no more undo states are available.
        manager.redo(); // Redo to "Hi there!"
        manager.redo(); // May print that no more redo states are available.

        // Display the current state.
        System.out.println("Current state: " + manager.getCurrentState());
    }
}