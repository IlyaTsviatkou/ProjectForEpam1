package com.company.array.action;

import com.company.array.entity.CustomArray;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.stream.IntStream;

public class ChangeArrayAction {
    final static Logger logger = LogManager.getLogger("log");
    public void oddToOne(CustomArray customArray) {
        int[] array = customArray.getArray();

        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0) {
                array[i] = 1;
            }
        }
        logger.trace("Changed all odd elements to 1");
    }

    public void evenToTwo(CustomArray customArray) {
        int[] array = customArray.getArray();

        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) {
                array[i] = 2;
            }
        }
        logger.trace("Changed all even elements to 2");
    }

    public void oddToOneStream(CustomArray array) {
        logger.trace("Changed all odd elements to 1");
       array.setArray(IntStream.of(array.getArray())
               .map(value -> value = (( value % 2 != 0 ) ? 1 : value ))
               .toArray());
    }

    public void evenToTwoStream(CustomArray array) {
        logger.trace("Changed all even elements to 2");
        array.setArray(IntStream.of(array.getArray())
                .map(value -> value = (( value % 2 == 0 ) ? 2 : value ))
                .toArray());
    }
}
