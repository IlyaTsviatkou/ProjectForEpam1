package com.company.array.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortAction {
    public int[] bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
        return array;
    }

    public int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array,low,high);
            quickSort(array,low,pi-1);
            quickSort(array,pi+1, high);
        }
        return array;
    }

    public int[] mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
        return array;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array,j,i);
            }
        }
        swap(array,i+1,high);
        return i+1;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void merge(int[] array, int left, int middle, int right) {
        int length1 = middle - left + 1;
        int length2 = right - middle;

        int[] leftTempArray = new int[length1];
        int[] rightTempArray = new int[length2];

        for (int i = 0; i < length1; ++i) {
            leftTempArray[i] = array[left + i];
        }
        for (int j = 0; j < length2; ++j) {
            rightTempArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < length1 && j < length2) {
            if (leftTempArray[i] <= rightTempArray[j]) {
                array[k] = leftTempArray[i];
                i++;
            }
            else {
                array[k] = rightTempArray[j];
                j++;
            }
            k++;
        }

        while (i < length1) {
            array[k] = leftTempArray[i];
            i++;
            k++;
        }

        while (j < length2) {
            array[k] = rightTempArray[j];
            j++;
            k++;
        }
    }
}
