package com.main;

import java.util.*;

public class SortHashMapValue {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>();

        map.put("2", "B");
        map.put("8", "A");
        map.put("4", "D");
        map.put("7", "F");
        map.put("6", "W");
        map.put("19", "J");
        map.put("1", "Z");

        ArrayList<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String,String> entry:list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        sortedMap.forEach((e1,e2)-> {
            System.out.println(e1+" "+e2);
        });

    }
}
