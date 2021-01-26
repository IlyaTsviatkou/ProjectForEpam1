package com.company.array.action;

import com.company.array.exception.ArrayActionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class FindInArrayAction {
    final static Logger logger = LogManager.getLogger("log");

    public int min(int[] array) throws ArrayActionException {
        if(array == null){
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            logger.trace("Found min element in array");
            return IntStream.of(array)
                    .min()
                    .getAsInt();
        }
    }

    public int max(int[] array) throws ArrayActionException {
        if(array == null) {
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            logger.trace("Found max element in array");
            return IntStream.of(array)
                    .max()
                    .getAsInt();
        }
    }

    public double average(int[] array) throws ArrayActionException {
        if(array == null) {
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            logger.trace("Found average element in array");
            return IntStream.of(array)
                    .average()
                    .getAsDouble();
        }
    }

    public int sum(int[] array) throws ArrayActionException {
        if(array == null) {
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            logger.trace("Found sum in array");
            return IntStream.of(array)
                    .sum();
        }
    }
}
