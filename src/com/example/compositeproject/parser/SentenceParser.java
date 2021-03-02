package com.example.compositeproject.parser;

import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.entity.CompositeText;
import com.example.compositeproject.entity.TypeComponent;
import com.example.compositeproject.exception.CustomException;

public class SentenceParser implements DataParser{
    private static final String LEXEME_SPLIT = "\s";
    private DataParser parser = new LexemeParser();

    @Override
    public ComponentText parseText(String sentence) throws CustomException {
        if (sentence == null || sentence.isEmpty()) {
            throw new CustomException("paragraph is null or empty");
        }
        CompositeText sentenceComponent = new CompositeText(TypeComponent.SENTENCE);
        String[] lexemes = sentence.split(LEXEME_SPLIT);
        for (String lexeme : lexemes) {
            ComponentText lexemeComponent = parser.parseText(lexeme);
            sentenceComponent.addComponent(lexemeComponent);
        }
        return sentenceComponent;
    }
}
