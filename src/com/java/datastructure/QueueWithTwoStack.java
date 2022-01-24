package com.java.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class QueueWithTwoStack {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        QueueSolution.queueOps(ops);
    }
}

class QueueSolution {
    public static void queueOps(List<String> ops) {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();
        for (String str : ops) {
            String[] operation = str.split(" ");
                if("1".equals(operation[0])){
                    /*if (!out.isEmpty()) {
                        while (out.size()>0) {
                            in.push(out.pop());
                        }
                    }*/
                    in.push(Integer.parseInt(operation[1]));
                }
            if( "2".equals(operation[0])){
                    if (out.isEmpty()) {
                        while (in.size()>0) {
                            out.push(in.pop());
                        }
                    }
                    if (!out.isEmpty()) {
                        out.pop();
                    }
                }
            if( "3".equals(operation[0])) {
                if (out.isEmpty()) {
                    while (in.size() > 0) {
                        out.push(in.pop());
                    }
                }
                if (!out.isEmpty()) {
                    System.out.println(out.peek());
                }
            }
        }
    }
}

/*10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2*/

