package test.com.company.array.data.test;

import com.company.array.data.DataConverter;
import com.company.array.data.DataReader;
import com.company.array.entity.CustomArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DataReaderTest {
    @Test
    public void readFileTest() {
        DataReader dataReader = new DataReader();
        String path = "src/main/resources/array.txt";
        ArrayList<String> strings = dataReader.readFile(path);
        ArrayList<String> resultStrings = new ArrayList<>() {
            {
                add("1 2 3 4 5  6 7sd");
                add("1 2ad a d");
                add("2 5 -1 -2 5 1");
            }
        };
        Assert.assertEquals(resultStrings,strings);
    }
}
