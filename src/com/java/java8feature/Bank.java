package com.java.java8feature;

public sealed interface  Bank permits HDFCBank,ICICIBank{
    public abstract String getName();
}
