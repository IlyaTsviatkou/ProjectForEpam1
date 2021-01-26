package test.com.company.array.action.test;

import com.company.array.action.CountArrayAction;
import com.company.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountArrayActionTest {
    CustomArray array = new CustomArray(2,5,-1,-2,5,1);
    CountArrayAction countArray = new CountArrayAction();

    @Test
    public void countNegativeTest() {
        int a = countArray.negative(array.getArray());
        Assert.assertEquals(2,a);
    }

    @Test
    public void countPositiveTest() {
        int b = countArray.positive(array.getArray());
        Assert.assertEquals(4,b);
    }
}
