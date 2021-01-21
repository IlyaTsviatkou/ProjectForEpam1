package test;

import com.company.action.ArrayCreator;
import com.company.entity.OwnArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayCreatorTest {
    int[] testAr = new int[]{2,5,-1,-2,5,1};
    @Test
    public void arrayCreatorTest() {
        OwnArray array = ArrayCreator.readFile("src/main/resources/files/array.txt");
        Assert.assertEquals(testAr,array.getArray());
    }
}
