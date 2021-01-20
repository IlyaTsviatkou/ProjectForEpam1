package com.company.action;

import com.company.entity.OwnArray;

import java.util.stream.IntStream;

public class ChangeArray {
    public static void oddToOne(OwnArray array) {
       array.setArray(IntStream.of(array.getArray())
               .map(value -> value = (( value % 2 != 0 ) ? 1 : value ))
               .toArray());
    }
    public static void evenToTwo(OwnArray array) {
        array.setArray(IntStream.of(array.getArray())
                .map(value -> value = (( value % 2 == 0 ) ? 2 : value ))
                .toArray());
    }
}
