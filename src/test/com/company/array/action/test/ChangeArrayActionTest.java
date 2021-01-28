package com.company.array.action.test;

import com.company.array.action.ChangeArrayAction;
import com.company.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeArrayActionTest {
    ChangeArrayAction changeArray = new ChangeArrayAction();
    CustomArray actualArray;
    @Test(dataProvider = "arrays_changedEvenArrays")
    public void changeArrayEvens(int[] array, int[] changedArray) {
        actualArray = new CustomArray(array);
        changeArray.evenToTwo(actualArray);
        Assert.assertEquals(changedArray,actualArray.getArray());
    }

    @Test(dataProvider = "arrays_changedOddArrays")
    public void changeArrayOdds(int[] array, int[] changedArray) {
        actualArray = new CustomArray(array);
        changeArray.oddToOne(actualArray);
        Assert.assertEquals(changedArray,actualArray.getArray());
    }

    @Test(dataProvider = "arrays_changedEvenArrays")
    public void changeArrayEvensStream(int[] array, int[] changedArray) {
        actualArray = new CustomArray(array);
        changeArray.evenToTwoStream(actualArray);
        Assert.assertEquals(changedArray,actualArray.getArray());
    }

    @Test(dataProvider = "arrays_changedOddArrays")
    public void changeArrayOddsStream(int[] array, int[] changedArray) {
        actualArray = new CustomArray(array);
        changeArray.oddToOneStream(actualArray);
        Assert.assertEquals(changedArray,actualArray.getArray());
    }

    @DataProvider(name = "arrays_changedOddArrays")
    public Object[] createArraysOdd() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 1, 4, 1}},
                {new int[] {51, 13, 2, -11, 123}, new int[] {1, 1, 2, 1, 1}},
                {new int[] {2, 1, 3}, new int[] {2, 1, 1}},
                {new int[] {-5, -4, -3, -2}, new int[] {1, -4, 1, -2}}
        };
    }

    @DataProvider(name = "arrays_changedEvenArrays")
    public Object[] createArraysEven() {
        return new Object[][] { {new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 2, 5}},
                {new int[] {51, 13, 2, -11, 123}, new int[] {51, 13, 2, -11, 123}},
                {new int[] {2, 1, 3}, new int[] {2, 1, 3}},
                {new int[] {-5, -4, -3, -2}, new int[] {-5, 2, -3, 2}}
        };
    }
}
