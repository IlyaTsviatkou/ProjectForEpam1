package com.company.array.entity;

public class CustomArray {
    private int[] array;

    public CustomArray(int... args)
    {
        this.array = args;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int... args) {
        this.array = args;
    }

    public int getElement(int index) {
        if(index < 0 || index > array.length - 1 ) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    public void setElement(int index, int value) {
        if(index < 0 || index > array.length - 1 ) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = value;
    }

}
