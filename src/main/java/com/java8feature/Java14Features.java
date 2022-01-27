package com.java8feature;

class Java14Features {
    public static void main(String[] args) {
        //Record class
        Company company = new Company("TCS", 1, "UK");
        System.out.println(company.name());

        // instanceOf
        Object obj = new String("Amit");
        if (obj instanceof String mystr) {
            System.out.println(mystr.length());
        }
    }
}
