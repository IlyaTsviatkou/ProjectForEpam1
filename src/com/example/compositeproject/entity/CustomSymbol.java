package com.example.compositeproject.entity;

import com.example.compositeproject.exception.CustomException;

import java.util.List;
import java.util.Objects;

public class CustomSymbol implements ComponentText{
    public static final int LENGTH = 1;
    private TypeComponent type;
    private char value;

    public CustomSymbol(TypeComponent type, char value) {
        this.type = type;
        this.value = value;
    }

    public void setType(TypeComponent type) {
        this.type = type;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public TypeComponent getType() {
        return type;
    }

    @Override
    public List<ComponentText> getComponents() throws CustomException {
        throw new CustomException("unsupported action");
    }

    public CustomSymbol() {
    }

    @Override
    public String toString() {
        return Character.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSymbol symbol = (CustomSymbol) o;
        return value == symbol.value && type == symbol.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public int countSymbol() {
        return LENGTH;
    }
}
