package DSA.SortingAlgorithms;


import java.util.Stack;

public class ExpressionConverter {

    // Method to define operator precedence
    public static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    // Convert infix to postfix expression
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // If the character is an operand (number/letter), add it to the output.
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If the character is '(', push it onto the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the character is ')', pop until '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop(); // Remove '(' from the stack
            }
            // If an operator is encountered.
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop any remaining operators from the stack.
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    // Convert infix to prefix expression
    public static String infixToPrefix(String infix) {
        // First, reverse the infix expression.
        StringBuilder input = new StringBuilder(infix);
        input.reverse();

        // Replace '(' with ')' and vice versa.
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                input.setCharAt(i, ')');
            } else if (c == ')') {
                input.setCharAt(i, '(');
            }
        }

        // Convert the modified expression to postfix.
        String reversedPostfix = infixToPostfix(input.toString());

        // The prefix expression is the reverse of the reversedPostfix.
        return new StringBuilder(reversedPostfix).reverse().toString();
    }

    // Main method to test the conversions
    public static void main(String[] args) {
        String infixExp = "A+B*(C-D)";
        System.out.println("Infix Expression: " + infixExp);

        String postfixExp = infixToPostfix(infixExp);
        System.out.println("Converted to Postfix: " + postfixExp);

        String prefixExp = infixToPrefix(infixExp);
        System.out.println("Converted to Prefix: " + prefixExp);
    }
}