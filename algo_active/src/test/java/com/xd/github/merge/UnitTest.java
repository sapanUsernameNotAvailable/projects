package com.xd.github.merge;

import com.xd.github.algo.merge.Merger;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    private static final Merger<Integer> merger = new Merger<>();

    @Test
    public void testRun() {
        // 1
        Integer[] mPlusNarray = new Integer[5];
        mPlusNarray[0] = 1;
        mPlusNarray[1] = 2;
        mPlusNarray[2] = 3;
        mPlusNarray[3] = 0;
        mPlusNarray[4] = 0;
        // 2
        Integer[] nArray = new Integer[2];
        nArray[0] = 4;
        nArray[1] = 5;
        // 3
        Integer[] resultArray = new Integer[5];
        resultArray[0] = 1;
        resultArray[1] = 2;
        resultArray[2] = 3;
        resultArray[3] = 4;
        resultArray[4] = 5;
        // 4
        merger.merger(mPlusNarray, nArray);
        Assert.assertArrayEquals(resultArray, mPlusNarray);
    }
    
    @Test
    public void testRun2() {
        // 1
        Integer[] mPlusNarray = new Integer[5];
        mPlusNarray[0] = 31;
        mPlusNarray[1] = 122;
        mPlusNarray[2] = 222;
        mPlusNarray[3] = 0;
        mPlusNarray[4] = 0;
        // 2
        Integer[] nArray = new Integer[2];
        nArray[0] = 5;
        nArray[1] = 43;
        // 3
        Integer[] resultArray = new Integer[5];
        resultArray[0] = 5;
        resultArray[1] = 31;
        resultArray[2] = 43;
        resultArray[3] = 122;
        resultArray[4] = 222;
        // 4
        merger.merger(mPlusNarray, nArray);
        Assert.assertArrayEquals(resultArray, mPlusNarray);
    }
}
