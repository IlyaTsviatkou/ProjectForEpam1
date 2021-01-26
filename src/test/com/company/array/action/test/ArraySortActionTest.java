package test.com.company.array.action.test;

import com.company.array.action.ArraySortAction;
import com.company.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySortActionTest {
    CustomArray unsortedArray = new CustomArray(3,1,4,2,5);
    int[] testAr = new int[]{1,2,3,4,5};
    ArraySortAction sort = new ArraySortAction();

    @Test
    public void arrayBubbleSortTest() {
        sort.bubbleSort(unsortedArray.getArray());
        Assert.assertEquals(testAr,unsortedArray.getArray());
    }

    @Test
    public void arrayMergeSortTest() {
        sort.mergeSort(unsortedArray.getArray(),0,unsortedArray.getArray().length-1);
        Assert.assertEquals(testAr,unsortedArray.getArray());
    }

    @Test
    public void arrayQuickSortTest() {
        sort.quickSort(unsortedArray.getArray(),0,unsortedArray.getArray().length-1);
        Assert.assertEquals(testAr,unsortedArray.getArray());
    }
}
