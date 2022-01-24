package com.main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHaspMapValueJava8 {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "B");
        map.put("8", "A");
        map.put("4", "D");
        map.put("7", "F");
        map.put("6", "W");
        map.put("19", "J");
        map.put("1", "Z");

      LinkedHashMap<String,String> sortedMap = map.entrySet().stream().sorted(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));

       sortedMap.forEach((e1,e2)-> System.out.println(e1 +"::"+e2));
       sortedMap.entrySet().stream().forEach(e-> System.out.println(e.getKey()+":"+e.getValue()));
    }
}
