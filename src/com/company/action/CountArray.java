package com.company.action;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class CountArray {
    public static int negative(int[] array){
        return (int) IntStream.of(array)
                .filter(value -> value<0)
                .count();
    }
    public static int positive(int[] array){
        return (int) IntStream.of(array)
                .filter(value -> value>=0)
                .count();
    }
}
