package com.company.validation;

import com.company.exception.InvalidCharacterException;

import java.util.Scanner;

public class Validation
{
    public static IntValidationResult isNumeric(String strNum) {
        IntValidationResult result =
                new IntValidationResult();
        try
        {
            result.value = Integer.parseInt(strNum);
            result.isValid = true;
            return result;
        }
        catch (NumberFormatException e)
        {

            result.isValid = false;
            result.value = 0;
            return result;
        }
    }
    public static StringValidationResult isStringArray(String str) {
        StringValidationResult result =
                new StringValidationResult();
        boolean hasOtherChars = !str.matches("[0-9\s\\-]*");
        if (!hasOtherChars) {
            result.isValid = true;
            result.value = str;
        }
        else{
            result.isValid = false;
            result.value = "";
        }
        return result;
    }
}