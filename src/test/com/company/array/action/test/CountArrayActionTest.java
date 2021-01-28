package com.company.array.action.test;

import com.company.array.action.CountArrayAction;
import com.company.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CountArrayActionTest {
    CountArrayAction countArray = new CountArrayAction();

    @Test(dataProvider = "arraysWithNegative")
    public void countNegativeTest(int[] array, int result) {
        int a = countArray.negative(array);
        Assert.assertEquals(result,a);
    }

    @Test(dataProvider = "arraysWithPositive")
    public void countPositiveTest(int[] array, int result) {
        int b = countArray.positive(array);
        Assert.assertEquals(result,b);
    }

    @DataProvider(name = "arraysWithNegative")
    public Object[] createArraysNegative() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, 0},
                {new int[] {51, 13, 2, -11, 123}, 1},
                {new int[] {2, -1, -3}, 2},
                {new int[] {-5, -4, -3, -2}, 4}
        };
    }

    @DataProvider(name = "arraysWithPositive")
    public Object[] createArraysPositive() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, 5},
                {new int[] {51, 13, 2, -11, 123}, 4},
                {new int[] {2, -1, -3}, 1},
                {new int[] {-5, -4, -3, -2}, 0}
        };
    }
}
