package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReverseListJava8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> res = reverseArray(arr);

        res.stream().forEach(System.out::println);



        bufferedReader.close();
        //bufferedWriter.close();
    }

    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        return IntStream.range(0,a.size()).mapToObj(n->a.get(a.size()-1-n)).collect(Collectors.toList());
        //return a.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }
}
