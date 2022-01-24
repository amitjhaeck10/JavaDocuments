package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class LongestSubStringProblem {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String str = in.readLine();

        HashSet<Character> charSet = new HashSet<>();
        int max = findLongestSubstring(str,charSet);
        System.out.println(max);
    }

    private static int findLongestSubstring(String str, HashSet<Character> charSet) {
        int pointer1=0,pointer2=0;
        int max = 0;
        if(str.length()==1){
            return 1;
        }
        while(pointer2 < str.length()){
            if(!charSet.contains(str.charAt(pointer2))){
                charSet.add(str.charAt(pointer2));
                pointer2++;
                max = Math.max(charSet.size(),max);
            }else{
                charSet.remove(pointer1);
                pointer1++;
            }
        }
        return max;
    }
}
