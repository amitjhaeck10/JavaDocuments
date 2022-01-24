package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransferCurrencyConvertor {

    private Map<String, Map<String, Double>> mapping = new HashMap<String, Map<String, Double>>();
    private boolean bInit = false;
    private boolean bFound = false;

    double convert(String src, double amount, String dst) throws Exception {
        if (src.equals(dst)) return amount;

        if (!bInit) {
            init();
            bInit = true;
        }

        bFound = false;
        if (mapping.get(src) == null) {
            throw new Exception("Invalid conversion");
        }

        List<String> visited = new ArrayList<>();
        visited.add(src);
        double d1 = getRate(visited, src, dst, 1);
        if (bFound)
            return d1 * amount;
        throw new Exception("No mapping Found , invalid currency conversion");
    }

    private double getRate(List<String> visited, String src, String dst, double rate) throws Exception {
        if (bFound == true) {
            return rate;
        }

        if (mapping.get(src).get(dst) != null) {
            bFound = true;
            return rate*mapping.get(src).get(dst);
        }

        double origRate = rate;
        for (String sInt : mapping.get(src).keySet()) {
            if (visited.contains(sInt)) {
                continue;
            }
            visited.add(sInt);
            rate = getRate(visited, sInt, dst, rate*mapping.get(src).get(sInt));
            if (bFound == true) {
                return rate;
            }
            visited.remove(sInt);
            rate = origRate;
        }

        return origRate;
    }

    private void init() {
        //Invalid case data, EUR to INR
        //insert("EUR", "USD", 1.2);
        //insert("USD", "EUR", 0.75);
        //insert("YEN", "INR", 1.2);
        //insert("INR", "YEN", 0.75);

        //Valid case data, EUR to INR
         insert("EUR", "USD", 1.2);
         insert("USD", "GBP", 0.75);
         insert("GBP", "AUD", 1.7);
         insert("AUD", "JPY", 90);
         insert("GBP", "JPY", 150);
         insert("JPY", "INR", 0.6);

//		insert("USD", "EUR", 1.0/1.2);
//		insert("GBP", "USD", 1.0/0.75);
//		insert("AUD", "GBP", 1.0/1.7);
//		insert("JPY", "AUD", 1.0/90);
//		insert("JPY", "GBP", 1.0/150);
//		insert("INR", "JPY", 1.0/0.6);
    }

    private void insert(String src, String dst, double rate) {
        if (mapping.get(src) == null) {
            Map<String, Double> map = new HashMap<String, Double>();
            map.put(dst, rate);
            mapping.put(src, map);
        } else if (mapping.get(src).get(dst) == null) {
            mapping.get(src).put(dst, rate);
        }
    }

    public static void main(String args[]) {
        //Reference from : https://www.careercup.com/question?id=5631096870928384
        try {
            double d = new TransferCurrencyConvertor().convert("EUR", 100, "GBP");
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
