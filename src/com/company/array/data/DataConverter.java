package com.company.array.data;

import com.company.array.entity.CustomArray;
import com.company.array.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataConverter {
    final static Logger logger = LogManager.getLogger("log");

    public int[] convertStringsToInts(ArrayList<String> strings) {
        ArrayList<Integer> array = new ArrayList<Integer>();

            for(String str : strings) {
                if (Validation.isStringArray(str)) {
                    String[] arrayStrings = str.trim().split(" ");

                    for (int j = 0; j < arrayStrings.length; j++) {
                        array.add(Integer.parseInt(arrayStrings[j]));
                    }
                    logger.trace("array was converted from string: " + str);
                    break;
                } else {
                    continue;
                }
            }
            return array.stream().mapToInt(i -> i).toArray();
    }
}
