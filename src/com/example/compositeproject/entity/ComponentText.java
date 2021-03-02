package com.example.compositeproject.entity;

import com.example.compositeproject.exception.CustomException;

import java.util.List;

public interface ComponentText {
    TypeComponent getType();
    List<ComponentText> getComponents() throws CustomException;
    int countSymbol();
}
