package com.company.entity;

public class OwnArray {

    private int[] array;
    private int size;

    public OwnArray(int... args)
    {
        this.size = args.length;
        this.array = args.clone();
    }

    public int[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public void setArray(int... args) {
        this.array = args.clone();
    }

    public int get(int index) {
        return this.array[index];
    }

    public void set(int index, int value) {
        this.array[index] = value;
    }

}
