package com.example.compositeproject.parser;

import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.exception.CustomException;

public interface DataParser {
    ComponentText parseText(String text) throws CustomException;
}
