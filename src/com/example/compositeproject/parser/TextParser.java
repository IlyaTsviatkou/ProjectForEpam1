package com.example.compositeproject.parser;

import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.entity.CompositeText;
import com.example.compositeproject.entity.TypeComponent;
import com.example.compositeproject.exception.CustomException;

public class TextParser implements DataParser{
    private DataParser parser = new ParagraphParser();
    private static final String PARAGRAPH_SPLIT = "\s{4}";
    @Override
    public ComponentText parseText(String text) throws CustomException {
        if(text == null || text.isEmpty()){
            throw new CustomException("text is empty or null");
        }
        CompositeText component = new CompositeText(TypeComponent.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_SPLIT);
        for(String paragraph : paragraphs) {
            ComponentText paragraphComponent = parser.parseText(paragraph);
            component.addComponent(paragraphComponent);
        }
        return component;
    }
}
