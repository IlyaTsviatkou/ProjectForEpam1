package com.company.array.data;

import com.company.array.entity.CustomArray;
import com.company.array.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {
    final static Logger logger = LogManager.getLogger("log");

    public ArrayList<String> readFile(String path){
        ArrayList<String> strings = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                strings.add(str);
            }
            logger.trace("read string from file: " + path);
            return strings;
        } catch (Exception ex) {
            logger.error(path + "was not found");
            return null;
        }
    }
}
