package test.com.company.array.action.test;

import com.company.array.action.ChangeArrayAction;
import com.company.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeArrayActionTest {
    ChangeArrayAction changeArray = new ChangeArrayAction();

    @Test
    public void changeArrayTest1() {
        CustomArray unsortedArray = new CustomArray(3,1,4,2,5);
        int[] resultArray = new int[]{3,1,2,2,5};
        changeArray.evenToTwo(unsortedArray);
        Assert.assertEquals(resultArray,unsortedArray.getArray());
    }

    @Test
    public void changeArrayTest2() {
        CustomArray unsortedArray = new CustomArray(3,1,4,2,5);
        int[] resultArray = new int[]{1,1,4,2,1};
        changeArray.oddToOne(unsortedArray);
        Assert.assertEquals(resultArray,unsortedArray.getArray());
    }
}
