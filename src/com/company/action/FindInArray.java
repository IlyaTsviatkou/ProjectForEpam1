package com.company.action;

import java.util.stream.IntStream;

public class FindInArray {
    public static int min(int[] array){
        return IntStream.of(array)
                .min()
                .getAsInt();
    }
    public static int max(int[] array){
        return IntStream.of(array)
                .max()
                .getAsInt();
    }
    public static double average(int[] array){
        return IntStream.of(array)
                .average()
                .getAsDouble();
    }
    public static int sum(int[] array){
        return IntStream.of(array)
                .sum();
    }
}
