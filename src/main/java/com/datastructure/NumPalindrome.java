package main.java.com.datastructure;


class NumPalindrome {
    public static void main(String[] args) {
        System.out.println(is_palindrome(123));
        System.out.println(armstrongNumber(153));
        System.out.println(modify("abCD"));
        System.out.println(areRotations("geeksforgeeks", "forgeeksgeeks"));
    }

    public static String is_palindrome(int n) {
        // Code here
        String numStr = Integer.toString(n) + "";
        char[] charArr = numStr.toCharArray();
        StringBuilder reverse = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            reverse.append(charArr[i]);
        }
        return reverse.toString().equals(numStr) ? "YES" : "NO";
    }

    static String armstrongNumber(int n) {
        // code here
        int temp = n;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            sum = sum + (rem * rem * rem);
            //System.out.println(sum);
        }
        if (sum == n) {
            return "YES";
        } else {
            return "NO";
        }
    }

    static String modify(String s) {
        // your code here
        String firstChar = String.valueOf(s.charAt(0));
        String result = "";
        System.out.println(firstChar);
        if (firstChar.toUpperCase().equals(firstChar)) {
            result = s.toUpperCase();
        } else if (firstChar.toLowerCase().equals(firstChar)) {
            result = s.toLowerCase();
        }
        return result;
    }

    public static boolean areRotations(String s1, String s2) {
        // Your code here
        String str = s1 + s1;
        boolean flag = false;
        if (str.contains(s2)) {
            flag = true;
        }
        return flag;
    }
}
