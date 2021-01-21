package test;

import com.company.action.ArraySort;
import com.company.entity.OwnArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySortTest {
    OwnArray unsortedArray = new OwnArray(3,1,4,2,5);
    int[] testAr = new int[]{1,2,3,4,5};
    @Test
    public void arrayBubbleSortTest() {
        ArraySort.bubleSort(unsortedArray.getArray());
        Assert.assertEquals(testAr,unsortedArray.getArray());
    }

    @Test
    public void arrayMergeSortTest() {
        ArraySort.mergeSort(unsortedArray.getArray(),0,unsortedArray.getArray().length-1);
        Assert.assertEquals(testAr,unsortedArray.getArray());
    }

    @Test
    public void arrayQuickSortTest() {
        ArraySort.quickSort(unsortedArray.getArray(),0,unsortedArray.getArray().length-1);
        Assert.assertEquals(testAr,unsortedArray.getArray());
    }
}
