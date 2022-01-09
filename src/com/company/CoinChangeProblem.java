package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class CoinChangeProblem {

    public static void main(String[] args) {
        //Reference : https://java2blog.com/coin-change-problem-java/#Problem
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> currencies = new ArrayList<>();
        for(int i=0;i<num;i++){
            currencies.add(sc.nextInt());
        }

        int amount = sc.nextInt();
        System.out.println("Number of cpmbination: "+currenciesChange(0,amount,currencies,""));
    }

    private static int currenciesChange(int ci, int remainingAmt, ArrayList<Integer> currencies, String paid) {
        if(remainingAmt==0){
            System.out.println(paid);
            return 1;
        }else if(remainingAmt<0){
            return 0;
        }
        int change = 0;
        for(int i=ci;i<currencies.size();i++){
            change += currenciesChange(i,remainingAmt-currencies.get(i),currencies,
                                                           (paid+Integer.toString(currencies.get(i))+","));
        }
        return change;
    }
}
