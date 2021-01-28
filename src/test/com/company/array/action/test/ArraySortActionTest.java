package com.company.array.action.test;

import com.company.array.action.ArraySortAction;
import com.company.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArraySortActionTest {
    ArraySortAction sort = new ArraySortAction();

    @Test(dataProvider = "arraysForSorting")
    public void arrayBubbleSortTest(int[] sortedArray, int[] unsortedArray) {
        sort.bubbleSort(unsortedArray);
        Assert.assertEquals(sortedArray,unsortedArray);
    }

    @Test(dataProvider = "arraysForSorting")
    public void arrayMergeSortTest(int[] sortedArray, int[] unsortedArray) {
        sort.mergeSort(unsortedArray,0,unsortedArray.length-1);
        Assert.assertEquals(sortedArray,unsortedArray);
    }

    @Test(dataProvider = "arraysForSorting")
    public void arrayQuickSortTest(int[] sortedArray, int[] unsortedArray) {
        sort.quickSort(unsortedArray,0,unsortedArray.length-1);
        Assert.assertEquals(sortedArray,unsortedArray);
    }

    @DataProvider(name = "arraysForSorting")
    public Object[] createArraysForSorting() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 2, 1, 3}},
                {new int[] {-11, 2, 13, 51, 123}, new int[] {51, 13, 2, -11, 123}},
                {new int[] {1, 2, 3}, new int[] {2, 1, 3}},
                {new int[] {-5, -4, -3, -2}, new int[] {-5, -4, -2, -3}}
        };
    }
}
