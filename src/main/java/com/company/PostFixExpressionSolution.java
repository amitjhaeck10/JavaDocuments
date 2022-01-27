package main.java.com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostFixExpressionSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluatePostFix(bufferedReader.readLine()));
    }

    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S) {
        char[] chrArr = S.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char chr : chrArr) {
            if (Character.isDigit(chr)) {
                stack.push(Character.getNumericValue(chr));
            } else {
                String operator = String.valueOf(chr);
                int right = stack.pop();
                int left = stack.pop();
                switch (operator) {
                    case "+": {
                        stack.push(left + right);
                        break;
                    }
                    case "-": {
                        stack.push(left - right);
                        break;
                    }
                    case "*": {
                        stack.push(left * right);
                        break;
                    }
                    case "/": {
                        stack.push(left / right);
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + operator);
                }
            }

        }
        return stack.pop();
    }
}
