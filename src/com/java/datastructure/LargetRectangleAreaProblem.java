package com.java.datastructure;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class RectangleResult {
    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */
    public static long largestRectangle(List<Integer> h) {
        // Add 0 element on last
        h.add(0);
        int maxArea = 0, currentArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1;i<h.size();i++){
            while(h.get(i) < h.get(stack.peek())){
                currentArea = h.get(stack.peek());
                stack.pop();

                if(stack.empty()){
                    currentArea = currentArea*i;
                    maxArea = Math.max(maxArea, currentArea);
                    break;
                }
                 currentArea = currentArea * (i - stack.peek() - 1);
                 maxArea = Math.max(maxArea, currentArea);
            }
            stack.push(i);
        }
        System.out.println(maxArea);
          return maxArea;
        }
   /* public static long largestRectangle1(List<Integer> h) {
        // Write your code here
        int rectangleArea = 0;
        Collections.sort(h);
        //rectangleArea = IntStream.range(0,h.size()).map(i->(h.get(i)+(h.size()-i-1)*h.get(i))).max().getAsInt();
        System.out.println("h= "+h);
        for(int i=0;i<h.size();i++){
            int area = h.get(i)+(h.size()-i-1)*h.get(i);
            System.out.println("area="+area);
            if(area>rectangleArea){
                rectangleArea = area;
            }
        }
        System.out.println(rectangleArea);
        return rectangleArea;
    }*/
}

public class LargetRectangleAreaProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = RectangleResult.largestRectangle(h);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

