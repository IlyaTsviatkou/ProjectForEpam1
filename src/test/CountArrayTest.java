package test;

import com.company.action.CountArray;
import com.company.entity.OwnArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountArrayTest {
    OwnArray array = new OwnArray(2,5,-1,-2,5,1);

    @Test
    public void countNegativeTest() {
        int a = CountArray.negative(array.getArray());
        Assert.assertEquals(2,a);
    }
@Test
    public void countPositiveTest() {
        int b = CountArray.positive(array.getArray());
        Assert.assertEquals(4,b);
    }

}
