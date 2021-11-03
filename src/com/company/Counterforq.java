package com.company;

public class Counterforq {
    public static int count(String str) {
        String target = "“";
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
