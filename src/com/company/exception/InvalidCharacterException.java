package com.company.exception;

public class InvalidCharacterException extends Exception{
    private String str;

    public String getString() {
        return str;
    }

    public InvalidCharacterException(String message, String str)
    {
        super(message);
        this.str = str;
    }
}
