package com.company.array.validation;

public class Validation
{
    private static String validChars = "[0-9\s\\-]*";

    public static boolean isNumeric(String strNum) {
        try {
            int value = Integer.parseInt(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isStringArray(String str) {
        boolean hasOtherChars = !str.matches(validChars);
        return !hasOtherChars;
    }
}