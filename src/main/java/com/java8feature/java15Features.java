package com.java8feature;

public class java15Features {

    public static void main(String[] args) {
        HDFCBank hdfcBank = new HDFCBank();
        System.out.println(hdfcBank.getName());
    }
}

final class HDFCBank implements Bank {
    public String getName() {
        return "HDFC";
    }
}

final class ICICIBank implements Bank {
    public String getName() {
        return "ICICI";
    }
}
