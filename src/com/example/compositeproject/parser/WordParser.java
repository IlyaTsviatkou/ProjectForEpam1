package com.example.compositeproject.parser;

import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.entity.CompositeText;
import com.example.compositeproject.entity.CustomSymbol;
import com.example.compositeproject.entity.TypeComponent;
import com.example.compositeproject.exception.CustomException;

public class WordParser implements DataParser{
    @Override
    public ComponentText parseText(String word) throws CustomException {
        CompositeText wordComponent = new CompositeText(TypeComponent.WORD);
        char[] symbols = word.toCharArray();
        CustomSymbol symbolComponent;
        for (char symbol : symbols) {
            symbolComponent = new CustomSymbol(TypeComponent.LETTER, symbol);
            wordComponent.addComponent(symbolComponent);
        }
        return wordComponent;
    }
}
