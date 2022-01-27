package com.java8feature;

import java.util.List;

public class Java12Features {

    public static void main(String[] args) {
        var n = 10;
        switch (n) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            case 10 -> {
                List.of(5, 4).stream().sorted().forEach(e -> System.out.println(e));
            }
            case 5 -> System.out.println("Five");
        }
    }
}
