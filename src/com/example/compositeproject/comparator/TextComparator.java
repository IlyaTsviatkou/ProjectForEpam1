package com.example.compositeproject.comparator;

import com.example.compositeproject.entity.ComponentText;
import com.example.compositeproject.exception.CustomException;

import java.util.Comparator;

public class TextComparator implements Comparator<ComponentText> {
    @Override
    public int compare(ComponentText component1, ComponentText component2) {
        int size1 = 0;
        int size2 = 0;
        try {
            size1 = component1.getComponents().size();
            size2 = component2.getComponents().size();
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return size1 - size2;
    }
}
