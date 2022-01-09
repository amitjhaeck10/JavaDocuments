package com.company;

import java.util.Optional;
import java.util.stream.IntStream;

public class fizzBuzzProblemInJava8 {

    public static void main(String[] args){
        IntStream.rangeClosed(1,15).forEach(n->System.out.println(fizzBuzzinJava8(n)));
    }

    public static String fizzBuzzinJava8(int num){
        String result = Optional.of(num).map(n-> (n%3==0?"Fizz":"")+(n%5==0? "Buzz":"")).get();
        return result.isEmpty()? Integer.toString(num): result;
    }

    void test(){
        ;
    }
}
