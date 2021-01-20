package com.company;

import com.company.action.ChangeArray;
import com.company.action.CountArray;
import com.company.action.FindInArray;
import com.company.entity.OwnArray;
import org.testng.annotations.*;
import org.apache.logging.log4j.*;

import java.util.Arrays;


public class Main {
       protected static final Logger LOG  = LogManager.getLogger("testLogger");
    public static void main(String[] args) {
        int[] f = new int[]{1,2,3,-4,-5,6,7,8,-9,0};
        OwnArray ar = new OwnArray(f);
        int a = FindInArray.min(ar.getArray());
        int b = CountArray.positive(ar.getArray());
        int c = CountArray.negative(ar.getArray());
        ChangeArray.evenToTwo(ar);
        LOG.error(Arrays.toString(ar.getArray()));
        LOG.error(a);
        LOG.error(b);
        LOG.error(c);


    }

    @Test
    public void A()
    {

    }
}
