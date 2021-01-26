package com.company.array.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.IntStream;

public class CountArrayAction {
    final static Logger logger = LogManager.getLogger("log");

    public int negative(int[] array){
        logger.trace("Counted negative elements in array");
        return (int) IntStream.of(array)
                .filter(value -> value<0)
                .count();
    }

    public int positive(int[] array){
        logger.trace("Counted positive elements in array");
        return (int) IntStream.of(array)
                .filter(value -> value>=0)
                .count();
    }
}
