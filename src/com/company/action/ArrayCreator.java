package com.company.action;

import com.company.entity.OwnArray;
import com.company.exception.InvalidCharacterException;
import com.company.validation.Validation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayCreator {
    public static OwnArray readFile(String path) {
        ArrayList<Integer> arrayFromFile = new ArrayList<Integer>();
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                if (Validation.isStringArray(str).isValid) {
                    String[] arrayStrings = str.trim().split(" ");
                    for (int j = 0; j < arrayStrings.length; j++) {
                        arrayFromFile.add(Integer.parseInt(arrayStrings[j]));
                    }
                    break;
                } else {
                    continue;
                }
            }
            return new OwnArray(arrayFromFile.stream().mapToInt(i -> i).toArray());
        }
        catch (Exception ex) {
            return null;
        }

    }
}
