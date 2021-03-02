package com.example.compositeproject.parser;

import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.entity.CompositeText;
import com.example.compositeproject.entity.CustomSymbol;
import com.example.compositeproject.entity.TypeComponent;
import com.example.compositeproject.exception.CustomException;

public class LexemeParser implements DataParser{
    private static final String WORD_CODE = "\\w+\\.\\w+\\(.*\\)";
    private static final String PUNCTUATION_MARK = "(\\p{Punct})";
    private static final String MARK_WORD_MARK = "(\\p{Punct}.+\\p{Punct})";
    private static final String MARK_WORD = "(\\p{Punct}.+)";
    private static final String CODE_MARK = "\\w+\\.\\w+\\(.*\\)\\p{Punct}";
    private static final String WORD_MARK = ".+\\p{Punct}";
    private static final String WORD_MARK_SPLIT = "(?=[,.!?)])";
    DataParser parser = new WordParser();

    @Override
    public ComponentText parseText(String lexeme) throws CustomException {
        if (lexeme == null || lexeme.isEmpty()) {
            throw new CustomException("lexeme is null or empty");
        }
        CompositeText lexemeComponent = new CompositeText(TypeComponent.LEXEME);
        String word;
        CustomSymbol symbol;
        if (lexeme.matches(WORD_CODE)) {
            ComponentText wordComponent = parser.parseText(lexeme);
            lexemeComponent.addComponent(wordComponent);
        } else if (lexeme.matches(PUNCTUATION_MARK)) {
            symbol = new CustomSymbol(TypeComponent.PUNCTUATION_MARK, lexeme.charAt(0));
            lexemeComponent.addComponent(symbol);
        } else if (lexeme.matches(MARK_WORD_MARK)) {
            Character firstSymbol = lexeme.charAt(0);
            symbol = new CustomSymbol(TypeComponent.PUNCTUATION_MARK, firstSymbol);
            lexemeComponent.addComponent(symbol);
            word = lexeme.substring(1, lexeme.length() - 1);
            ComponentText wordComponent = parser.parseText(word);
            lexemeComponent.addComponent(wordComponent);
            Character lastSymbol = lexeme.charAt(lexeme.length() - 1);
            symbol = new CustomSymbol(TypeComponent.PUNCTUATION_MARK, lastSymbol);
            lexemeComponent.addComponent(symbol);
        } else if (lexeme.matches(MARK_WORD)) {
            Character firstSymbol = lexeme.charAt(0);
            symbol = new CustomSymbol(TypeComponent.PUNCTUATION_MARK, firstSymbol);
            lexemeComponent.addComponent(symbol);
            word = lexeme.substring(1, lexeme.length());
            ComponentText wordComponent = parser.parseText(word);
            lexemeComponent.addComponent(wordComponent);
        } else if (lexeme.matches(CODE_MARK)) {
            word = lexeme.substring(0, lexeme.length() - 1);
            ComponentText wordComponent = parser.parseText(word);
            lexemeComponent.addComponent(wordComponent);
            Character lastSymbol = lexeme.charAt(lexeme.length() - 1);
            symbol = new CustomSymbol(TypeComponent.PUNCTUATION_MARK, lastSymbol);
            lexemeComponent.addComponent(symbol);
        } else if (lexeme.matches(WORD_MARK)) {
            String[] lexemeElements = lexeme.split(WORD_MARK_SPLIT);
            for (String element : lexemeElements) {
                if (element.matches(PUNCTUATION_MARK)) {
                    Character markSymbol = element.charAt(0);
                    symbol = new CustomSymbol(TypeComponent.PUNCTUATION_MARK, markSymbol);
                    lexemeComponent.addComponent(symbol);
                } else {
                    ComponentText wordComponent = parser.parseText(element);
                    lexemeComponent.addComponent(wordComponent);
                }
            }
        } else {
            ComponentText wordComponent = parser.parseText(lexeme);
            lexemeComponent.addComponent(wordComponent);
        }
        return lexemeComponent;
    }
}

