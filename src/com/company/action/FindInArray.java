package com.company.action;

import com.company.exception.ArrayActionException;

import java.util.stream.IntStream;

public class FindInArray {
    public static int min(int[] array) throws ArrayActionException {
        if(array == null) throw new ArrayActionException("Array is null",array);
        else {
            return IntStream.of(array)
                    .min()
                    .getAsInt();
        }
    }
    public static int max(int[] array) throws ArrayActionException {
        if(array == null) throw new ArrayActionException("Array is null",array);
        else {
            return IntStream.of(array)
                    .max()
                    .getAsInt();
        }
    }
    public static double average(int[] array) throws ArrayActionException {
        if(array == null) throw new ArrayActionException("Array is null",array);
        else {
            return IntStream.of(array)
                    .average()
                    .getAsDouble();
        }
    }
    public static int sum(int[] array) throws ArrayActionException {
        if(array == null) throw new ArrayActionException("Array is null",array);
        else {
            return IntStream.of(array)
                    .sum();
        }
    }
}
