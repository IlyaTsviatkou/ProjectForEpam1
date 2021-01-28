package com.company.array.action;

import com.company.array.exception.ArrayActionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class FindInArrayAction {
    final static Logger logger = LogManager.getLogger("log");

    public int minStream(int[] array) throws ArrayActionException {
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

    public int maxStream(int[] array) throws ArrayActionException {
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

    public double averageStream(int[] array) throws ArrayActionException {
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

    public int sumStream(int[] array) throws ArrayActionException {
        if(array == null) {
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            logger.trace("Found sum in array");
            return IntStream.of(array)
                    .sum();
        }
    }

    public int min(int[] array) throws ArrayActionException {
        if(array == null){
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                if(min > array[i]) {
                    min = array[i];
                }
            }
            logger.trace("Found min element in array");
            return min;
        }
    }

    public int max(int[] array) throws ArrayActionException {
        if(array == null) {
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if(max < array[i]) {
                    max = array[i];
                }
            }
            logger.trace("Found max element in array");
            return max;
        }
    }

    public double average(int[] array) throws ArrayActionException {
        if(array == null) {
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            int average = 0;
            for (int i = 0; i < array.length; i++) {
                average += array[i];
            }
            logger.trace("Found average element in array");
            return (double) average/array.length;
        }
    }

    public int sum(int[] array) throws ArrayActionException {
        if(array == null) {
            logger.error("Array is null");
            throw new ArrayActionException("Array is null");
        } else {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            logger.trace("Found sum in array");
            return sum;
        }
    }
}
