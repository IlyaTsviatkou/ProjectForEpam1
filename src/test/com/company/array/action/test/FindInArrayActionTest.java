package com.company.array.action.test;

import com.company.array.action.*;
import com.company.array.entity.CustomArray;
import com.company.array.exception.ArrayActionException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindInArrayActionTest {
    CustomArray array = new CustomArray(2,5,-1,-2,5,1);
    FindInArrayAction findInArray = new FindInArrayAction();

    @Test(dataProvider = "arraysMin")
    public void findMinTest(int[] array, int result) throws ArrayActionException {
        int min = findInArray.min(array);
        Assert.assertEquals(result,min);
    }

    @Test(dataProvider = "arraysMax")
    public void findMaxTest(int[] array, int result) throws ArrayActionException {
        int max = findInArray.max(array);
        Assert.assertEquals(result,max);
    }

    @Test(dataProvider = "arraysAverage")
    public void findAverageTest(int[] array, double result) throws ArrayActionException {
        double average = findInArray.average(array);
        Assert.assertEquals(result,average);
    }

    @Test(dataProvider = "arraysSum")
    public void findSumTest(int[] array, int result) throws ArrayActionException {
        int sum = findInArray.sum(array);
        Assert.assertEquals(result,sum);
    }

    @DataProvider(name = "arraysMin")
    public Object[] createArraysMin() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, 1},
                {new int[] {51, 13, 2, -11, 123}, -11},
                {new int[] {2, -1, -3}, -3},
                {new int[] {-5, -4, -3, -2}, -5}
        };
    }

    @DataProvider(name = "arraysMax")
    public Object[] createArraysMax() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, 5},
                {new int[] {51, 13, 2, -11, 123}, 123},
                {new int[] {2, -1, -3}, 2},
                {new int[] {-5, -4, -3, -2}, -2}
        };
    }

    @DataProvider(name = "arraysAverage")
    public Object[] createArraysAverage() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, 3.0},
                {new int[] {51, 13, 2, -11, 123}, 35.6},
                {new int[] {2, -1, -3}, (double) -2/3},
                {new int[] {-5, -4, -3, -2}, -3.5}
        };
    }

    @DataProvider(name = "arraysSum")
    public Object[] createArraysSum() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, 15},
                {new int[] {51, 13, 2, -11, 123}, 178},
                {new int[] {2, -1, -3}, -2},
                {new int[] {-5, -4, -3, -2}, -14}
        };
    }
}
