package main.java.com.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class GameResult {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        int maxScore = 0, count1 = 0, count2 = 0, sum = 0;
        for (Integer st1 : a) {
            if (sum + st1 > maxSum) {
                break;
            }
            sum += st1;
            count1++;
        }
        maxScore = count1;
        System.out.println("maxScore 1= " + maxScore + " sum 1=" + sum);

        for (Integer st2 : b) {
            sum += st2;
            count2++;
            if (sum > maxSum && count1 > 0) {
                sum = sum - a.get(count1 - 1);
                count1--;
            }
            maxScore = (sum <= maxSum) ? Math.max(maxScore, count1 + count2) : maxScore;
        }
        return maxScore;
    }

}

public class GameTwoStacksProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int maxSum = Integer.parseInt(firstMultipleInput[2]);

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = GameResult.twoStacks(maxSum, a, b);

                //bufferedWriter.write(String.valueOf(result));
                //bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

