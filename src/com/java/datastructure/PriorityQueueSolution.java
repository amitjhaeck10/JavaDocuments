package com.java.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PriorityQueueSolution {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        int size = Integer.parseInt(in.readLine().trim());
        List<Integer> q = new LinkedList<Integer>();

        IntStream.range(0,q.size()).forEach(n-> System.out.print(q.get(n+2)));
        List<String> ops = IntStream.range(0, 8).mapToObj(i -> {
                    try {
                        return in.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).collect(toList());

        HashMap<Integer, Integer> res = priorityQueueOperation(ops,size);

        res.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).forEach(e-> System.out.println(e.getKey()+" "+e.getValue()));
    }

    private static HashMap<Integer, Integer> priorityQueueOperation(List<String> ops,int size) {
        HashMap<Integer, Integer> queueMap = new LinkedHashMap<>(size);
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for (String line : ops) {
            String[] strArr = line.split(" ");
            if (strArr[0].equals("enqueue")) {
                enqueue(queueMap,list,strArr,size);

            } else if (strArr[0].equals("dequeue") && !queueMap.isEmpty()) {
                dequeue(queueMap,list);
            }
        }
        return queueMap;
    }

    private static void dequeue(HashMap<Integer, Integer> queueMap, ArrayList<Integer> list) {
        Integer max = list.stream().max(Comparator.naturalOrder()).get();
        removeFromQueue(queueMap,max);
        list.remove(max);
    }

    private static void enqueue(HashMap<Integer, Integer> queueMap, ArrayList<Integer> list, String[] strArr,int size) {
        int value = Integer.parseInt(strArr[1]);
        int priority = Integer.parseInt(strArr[2]);
        if (queueMap.size() < size) {
            queueMap.put(value, priority);
            list.add(priority);
        } else {
            Integer minKey = list.stream().min(Comparator.naturalOrder()).get();
            if (minKey < priority) {
                removeFromQueue(queueMap,minKey);
                list.remove(minKey);
                queueMap.put(value, priority);
                list.add(priority);
            }
        }
    }

    private static void removeFromQueue(HashMap<Integer, Integer> queueMap, Integer priority) {
        List<Map.Entry<Integer, Integer>> entrylist = queueMap.entrySet().stream().filter(e -> e.getValue().intValue() == priority.intValue()).collect(toList());
        Integer maxKey = entrylist.get(0).getKey();
        queueMap.remove(maxKey);
    }

/*3
 enqueue 5 3
 enqueue 6 5
 enqueue 1 -1
 dequeue
 enqueue -2 0
 dequeue
 enqueue 3 1
 enqueue 4 2*/


}

