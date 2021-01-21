package test;

import com.company.action.*;
import com.company.entity.OwnArray;
import com.company.exception.ArrayActionException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindInArrayTest {
    OwnArray array = new OwnArray(2,5,-1,-2,5,1);

    @Test
    public void findMinTest() throws ArrayActionException {
        int min = FindInArray.min(array.getArray());
        Assert.assertEquals(-2,min);
    }

    @Test
    public void findMaxTest() throws ArrayActionException {
        int max = FindInArray.max(array.getArray());
        Assert.assertEquals(5,max);
    }

    @Test
    public void findAverageTest() throws ArrayActionException {
        double average = FindInArray.average(array.getArray());
        Assert.assertEquals((double)10/6,average);
    }

    @Test
    public void findSumTest() throws ArrayActionException {
        int sum = FindInArray.sum(array.getArray());
        Assert.assertEquals(10,sum);
    }

}
