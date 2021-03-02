package com.example.compositeproject.parser;

import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.entity.CompositeText;
import com.example.compositeproject.entity.TypeComponent;
import com.example.compositeproject.exception.CustomException;

public class ParagraphParser implements DataParser{
    private static final String SENTENCE_SPLIT = "(?<=([.!?.{3}]\s))";
    private DataParser parser = new SentenceParser();
    @Override
    public ComponentText parseText(String paragraph) throws CustomException {
        if (paragraph == null || paragraph.isEmpty()) {
            throw new CustomException("paragraph is null or empty");
        }
        CompositeText paragraphComponent = new CompositeText(TypeComponent.PARAGRAPH);
        String[] sentenceData = paragraph.split(SENTENCE_SPLIT);
        for (String sentence : sentenceData) {
            ComponentText sentenceComponent = parser.parseText(sentence);
            paragraphComponent.addComponent(sentenceComponent);
        }
        return paragraphComponent;
    }
}
