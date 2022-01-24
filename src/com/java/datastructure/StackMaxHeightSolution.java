package com.java.datastructure;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class StackResult {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        int maxHeight =0;

        Collections.reverse(h1);
        Collections.reverse(h2);
        Collections.reverse(h3);

        for(Integer num: h1){
            if(st1.empty()){
                st1.push(num);
            }else{
                int a = num+st1.peek();
                st1.push(a);
            }
        }

        for(Integer num: h2){
            if(st2.empty()){
                st2.push(num);
            }else{
                int a = num+st2.peek();
                st2.push(a);
            }
        }

        for(Integer num: h3){
            if(st3.empty()){
                st3.push(num);
            }else{
                int a = num+st3.peek();
                st3.push(a);
            }
        }

        // return st1.pop();
        while(!st1.isEmpty()&&!st2.isEmpty()&&!st3.isEmpty()){
            int stack1Height = st1.peek();
            int stack2Height = st2.peek();
            int stack3Height = st3.peek();

            if(stack1Height==stack2Height && stack2Height==stack3Height){
                return st1.peek();
            }
            if(stack1Height>stack2Height||stack1Height>stack3Height){
                st1.pop();
            }else if(stack2Height>stack1Height||stack2Height>stack3Height){
                st2.pop();
            }else if(stack3Height>stack1Height||stack1Height>stack2Height){
                st3.pop();
            }
        }
      return maxHeight;
    }

}

public class StackMaxHeightSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = StackResult.equalStacks(h1, h2, h3);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

