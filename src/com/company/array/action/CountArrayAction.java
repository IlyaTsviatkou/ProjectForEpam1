package com.company.array.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.IntStream;

public class CountArrayAction {
    final static Logger logger = LogManager.getLogger("log");
    public int negative(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 0) {
                count++;
            }
        }
        logger.trace("Counted negative elements in array");
        return count;
    }

    public int positive(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] >= 0) {
                count++;
            }
        }
        logger.trace("Counted positive elements in array");
        return count;
    }

    public int negativeStream(int[] array){
        logger.trace("Counted negative elements in array");
        return (int) IntStream.of(array)
                .filter(value -> value<0)
                .count();
    }

    public int positiveStream(int[] array){
        logger.trace("Counted positive elements in array");
        return (int) IntStream.of(array)
                .filter(value -> value>=0)
                .count();
    }
}
