package com.company.array.action;

import com.company.array.entity.CustomArray;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.stream.IntStream;

public class ChangeArrayAction {
    final static Logger logger = LogManager.getLogger("log");

    public void oddToOne(CustomArray array) {
        logger.trace("Changed all odd elements to 1");
       array.setArray(IntStream.of(array.getArray())
               .map(value -> value = (( value % 2 != 0 ) ? 1 : value ))
               .toArray());
    }

    public void evenToTwo(CustomArray array) {
        logger.trace("Changed all even elements to 2");
        array.setArray(IntStream.of(array.getArray())
                .map(value -> value = (( value % 2 == 0 ) ? 2 : value ))
                .toArray());
    }
}
