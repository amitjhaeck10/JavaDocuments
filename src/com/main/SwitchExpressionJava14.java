package com.main;

import java.util.Arrays;

public class SwitchExpressionJava14 {

    public static void main(String[] args) {
        switch (2){
            case 1-> {
                System.out.println("Inside case 1 = " + args.length);
            }
            case 2 -> System.out.println("args = " + Arrays.deepToString(args).isEmpty());
            case 3-> System.out.println("args1 = " + Arrays.deepToString(args).compareTo("Amit"));
        };
    }
}
