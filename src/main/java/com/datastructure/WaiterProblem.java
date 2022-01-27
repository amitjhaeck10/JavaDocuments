package main.java.com.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ResultWaiter {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */
    public static List<Integer> waiter(List<Integer> number, int q) {
        // Write your code here
        List<Integer> output = new ArrayList<>();
        List<Integer> divide = new ArrayList<>();
        int prime = 2;
        while (divide.size() < q) {
            if (isPrimeBruteForce(prime)) {
                divide.add(prime);
            }
            prime++;
        }
        System.out.println("divide: " + divide);
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        Stack<Integer> answer = new Stack<>();

        for (int i = 0; i < divide.size(); i++) {
            if (divide.get(i) == 2) {
                for (int a = number.size() - 1; a >= 0; a--) {
                    if (number.get(a) % 2 != 0) {
                        A.push(number.get(a));
                    } else {
                        B.push(number.get(a));
                    }
                }
                while (!B.isEmpty()) {
                    answer.push(B.pop());
                }
                number.clear();
                while (!A.isEmpty()) {
                    number.add(A.pop());
                }
                // A and B stack empty
            } else {
                int div = divide.get(i);
                for (int a = 0; a < number.size(); a++) {
                    if (number.get(a) % div != 0) {
                        A.push(number.get(a));
                    } else {
                        B.push(number.get(a));
                    }
                }
                while (!B.isEmpty()) {
                    answer.push(B.pop());
                }
                number.clear();
                while (!A.isEmpty()) {
                    number.add(A.pop());
                }
            }
        }
        for (int num : number) {
            answer.push(num);
        }
        output = answer.stream().collect(Collectors.toList());
        return output;
    }

    public static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

public class WaiterProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ResultWaiter.waiter(number, q);
        System.out.println(result);

        bufferedReader.close();
    }
}
