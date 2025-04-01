package DSA.StacksAndQueues;

import java.util.Stack;

public class StockSpan {

    // Function to calculate span values for given stock prices
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // will store indices of prices

        // Process every price
        for (int i = 0; i < n; i++) {
            // Pop indices whose corresponding prices are less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, current price is greater than all left elements
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push this element's index into the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.println("Stock span values:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}