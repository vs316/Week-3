package DSA.StacksAndQueues;

import java.util.Stack;

public class SortStackUsingRecursion {

    // This function sorts the stack using recursion.
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int temp = stack.pop();
            // Recursively sort the remaining stack
            sortStack(stack);
            // Insert the removed element back in sorted order
            sortedInsert(stack, temp);
        }
    }

    // Helper function that inserts an element in a sorted stack
    private static void sortedInsert(Stack<Integer> stack, int element) {
        // If the stack is empty or the current element is less than or equal
        // to the top element, push it directly.
        if (stack.isEmpty() || element <= stack.peek()) {
            stack.push(element);
        } else {
            // Otherwise, remove the top element and recursively call sortedInsert.
            int temp = stack.pop();
            sortedInsert(stack, element);
            // After inserting the element at correct position, push back the removed element.
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        // Push some unsorted values onto the stack
        myStack.push(34);
        myStack.push(3);
        myStack.push(31);
        myStack.push(98);
        myStack.push(92);
        myStack.push(23);

        System.out.println("Original Stack: " + myStack);

        // Sort the stack recursively
        sortStack(myStack);

        System.out.println("Sorted Stack: " + myStack);
    }
}