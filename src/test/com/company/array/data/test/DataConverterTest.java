package test.com.company.array.data.test;

import com.company.array.data.DataConverter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DataConverterTest {
    @Test
    public void converterStringsToInts(){
        DataConverter dataConverter = new DataConverter();
        ArrayList<String> strings = new ArrayList<>() {
            {
                add("1 2 3 4 5  6 7sd");
                add("1 2ad a d");
                add("2 5 -1 -2 5 1");
            }
        };
        int[] array = dataConverter.convertStringsToInts(strings);
        int[] resultArray = new int[]{2,5,-1,-2,5,1};
        Assert.assertEquals(resultArray,array);
    }
}
