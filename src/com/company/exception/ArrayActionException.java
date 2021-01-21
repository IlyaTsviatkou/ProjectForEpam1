package com.company.exception;

public class ArrayActionException extends Exception {
    private int[] array;

    public int[] getArray() {
        return array;
    }

    public ArrayActionException(String message, int[] array)
    {
        super(message);
        this.array = array;
    }
}
