package main.java.com.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;


class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isBalanced(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "NO";
        }
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char ch : charArray) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char value = stack.pop();
                if (value == '(' && ch != ')') {
                    return "NO";
                } else if (value == '{' && ch != '}') {
                    return "NO";
                } else if (value == '[' && ch != ']') {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class BalanceBracketsProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);
                System.out.println(result);

                //bufferedWriter.write(result);
                //bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

