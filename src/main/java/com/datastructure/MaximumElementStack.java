package main.java.com.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class MaxResult {
    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */
    public static List<Integer> getMax_1(List<String> operations) {
        // Write your code here
        List<Integer> output = new ArrayList<>();

        Stack<Integer> st = new Stack<>();
        for (String str : operations) {
            String[] arr = str.split(" ");

            if (arr[0].equals("1")) {
                st.push(Integer.parseInt(arr[1]));
            } else if (arr[0].equals("2")) {
                st.pop();
            } else if (arr[0].equals("3")) {
                if (!st.isEmpty()) {
                    Optional<Integer> max = st.stream().reduce(Integer::max);
                    max.ifPresent(output::add);
                }
            }
        }
        return output;
    }

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        List<Integer> output = new ArrayList<>();

        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        maxStack.push(Integer.MIN_VALUE);

        for (String str : operations) {
            String[] arr = str.split(" ");

            if (arr[0].equals("1")) {
                mainStack.push(Integer.parseInt(arr[1]));
                int item = mainStack.peek();
                int maxvalue = maxStack.peek();
                int result = item > maxvalue ? maxStack.push(item) : maxStack.push(maxvalue);
            } else if (arr[0].equals("2")) {
                mainStack.pop();
                maxStack.pop();
            } else if (arr[0].equals("3")) {
                output.add(maxStack.peek());
            }
        }
        return output;
    }

}

public class MaximumElementStack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = MaxResult.getMax(ops);
        System.out.println("res size" + res.size());
        res.forEach(System.out::println);
        /*bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

