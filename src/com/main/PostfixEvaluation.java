package com.main;

import java.util.Stack;

class PostfixEvaluation {
    public static void main(String[] args) {
        String[] strArr = "2 3 1 * + 9 -".split(" ");
        System.out.println(calculator(strArr));
    }

    public static int calculator(String[] strArr) {
        Stack<Integer> operands = new Stack<Integer>();

        for(String str : strArr) {
            if (str.trim().equals("")) {
                continue;
            }

            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int right = operands.pop();
                    int left = operands.pop();
                    int value = 0;
                    switch(str) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Integer.parseInt(str));
                    break;
            }
        }
        return operands.pop();
    }
}
