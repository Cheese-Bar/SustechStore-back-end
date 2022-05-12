package com.example.SustechStore.util;

public class StringUtils {
    public static void main(String[] args) {
        String test = " 。     。 周贤玮  ！。 ";
        System.out.println(trimChars(test, " ！。"));
        System.out.println(trimChars(test));
    }

    public static String trimChars(String srcStr, String splitter) {
        splitter = "[" + splitter + "]";
        String regex = "^" + splitter + "*|" + splitter + "*$";
        return srcStr.replaceAll(regex, "");
    }

    public static String trimChars(String srcStr) {
        String splitter = "[ 。]";
        String regex = "^" + splitter + "*|" + splitter + "*$";
        return srcStr.replaceAll(regex, "");
    }
}
