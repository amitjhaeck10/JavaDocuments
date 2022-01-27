package com.java8feature;

import java.util.List;
import java.util.Set;

public class Java9Feature {

    public static void main(String[] args) {
        //Jshell:Jdk CLI to write java programme

        //Jigsaw project: JDK modularisation

        // Introduce of collections factory method to create immutable collection
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Set.of(5, 6, 7, 8, 9).stream().forEach(System.out::println);

    }
}
