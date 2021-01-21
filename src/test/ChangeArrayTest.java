package test;

import com.company.action.ChangeArray;
import com.company.entity.OwnArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeArrayTest {
    OwnArray unsortedArray = new OwnArray(3,1,4,2,5);
    OwnArray unsortedArray2 = new OwnArray(3,1,4,2,5);
    int[] testAr = new int[]{1,1,4,2,1};
    int[] testAr2 = new int[]{3,1,2,2,5};

    @Test
    public void changeArrayTest1() {
        ChangeArray.evenToTwo(unsortedArray);
        Assert.assertEquals(testAr2,unsortedArray.getArray());
    }

    @Test
    public void changeArrayTest2() {
        ChangeArray.oddToOne(unsortedArray2);
        Assert.assertEquals(testAr,unsortedArray2.getArray());
    }


}
