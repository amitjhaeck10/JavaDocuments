package main.java.com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromeProblem {

    static int start;
    static int strLength;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String str = in.readLine();

        Solution sol = new Solution();
        String palindromeStr = sol.longestPalindrome(str);
        //String palindromeStr = findLongestPalindrome(str);
        System.out.println(palindromeStr);
    }

    private static String findLongestPalindrome(String str) {
        int strLength = str.length();
        if (strLength < 2) {
            return str;
        }
        for (int i = 0; i < strLength - 1; i++) {
            extendWindow(str, i, i + 1);
            extendWindow(str, i, i);
        }
        return str.substring(start, start + strLength);
    }

    private static void extendWindow(String str, int start, int end) {
        if (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }

        if (strLength < end - start - 1) {
            start = start + 1;
            strLength = end - start - 1;
        }
    }
}

class Solution {

    int resultStart;
    int resultLength;

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }
        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}
