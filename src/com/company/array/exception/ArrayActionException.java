package com.company.array.exception;

public class ArrayActionException extends Exception {
    public ArrayActionException() {
    }

    public ArrayActionException(String message) {
        super(message);
    }

    public ArrayActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayActionException(Throwable cause)
    {
        super(cause);
    }
}
