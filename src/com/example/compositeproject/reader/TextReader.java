package com.example.compositeproject.reader;

import com.example.compositeproject.exception.CustomException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {

    public String read(String filePath) throws CustomException {
        if (filePath == null) {
            throw new CustomException("filePath is null");
        }
        Path path = Paths.get(filePath);
        String text;
        try (Stream<String> streamLines = Files.lines(path)) {
            text = streamLines.collect(Collectors.joining());
        } catch (IOException e) {
         //   logger.log(Level.ERROR, "file " + filePath + " not found", e);
            throw new CustomException("file " + filePath + " not found", e);
        }
       // logger.log(Level.INFO, "read data from file : " + text);
        return text;
    }
}
