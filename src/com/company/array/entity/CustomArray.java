package com.company.array.entity;

import java.util.Arrays;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        if (array == null) {
            return 0;
        }

        int prime = 31;
        int result = 1;

        for (int element : array) {
            result = prime * result + element;
        }

        return result;
    }

    @Override
    public String toString() {
        String arrayString = "";
        for (int elem : array) {
            arrayString += String.valueOf(elem)+ " ";
        }
        return "CustomArray{" +
                "array=" + arrayString +
                '}';
    }
}
