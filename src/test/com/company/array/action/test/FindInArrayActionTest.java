package test.com.company.array.action.test;

import com.company.array.action.*;
import com.company.array.entity.CustomArray;
import com.company.array.exception.ArrayActionException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindInArrayActionTest {
    CustomArray array = new CustomArray(2,5,-1,-2,5,1);
    FindInArrayAction findInArray = new FindInArrayAction();

    @Test
    public void findMinTest() throws ArrayActionException {
        int min = findInArray.min(array.getArray());
        Assert.assertEquals(-2,min);
    }

    @Test
    public void findMaxTest() throws ArrayActionException {
        int max = findInArray.max(array.getArray());
        Assert.assertEquals(5,max);
    }

    @Test
    public void findAverageTest() throws ArrayActionException {
        double average = findInArray.average(array.getArray());
        Assert.assertEquals((double)10/6,average);
    }

    @Test
    public void findSumTest() throws ArrayActionException {
        int sum = findInArray.sum(array.getArray());
        Assert.assertEquals(10,sum);
    }

}
