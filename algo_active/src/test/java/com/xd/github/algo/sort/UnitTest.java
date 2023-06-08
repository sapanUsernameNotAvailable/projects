package com.xd.github.algo.sort;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    private static final QuickSelect<Integer> quickSelector = new QuickSelect<>();

    static Integer[] data = getInputData();
    private static Integer[] getInputData() {
        Integer[] data = new Integer[5];
        data[0] = 20;
        data[1] = 40;
        data[2] = 50;
        data[3] = 10;
        data[4] = 30;
        return data;
    }

    //@Test
    public void testRun() {
        int kSmallesttPosition = quickSelector.getKSmallestPosition(data, 3);
        Assert.assertEquals((long) data[kSmallesttPosition], 40L);
    }

    @Test
    public void testSortAroundArray() {
        for (int i = 0; i < data.length;i++) {
            testSortAround(i);
        }
    }
    
    private void testSortAround(int orgPivotIndex) {
        int orgPivotVal = data[orgPivotIndex];

        int finalpivotIndex = quickSelector.sortAround(data, orgPivotIndex);
        int finalPivotVal = data[finalpivotIndex];

        Assert.assertEquals(orgPivotVal, finalPivotVal);

        for (int i = 0; i < data.length; i++) {
            if (i < finalpivotIndex) {
                Assert.assertTrue(data[i] < orgPivotVal);
            }
            if (i > finalpivotIndex) {
                Assert.assertTrue(data[i] > orgPivotVal);
            }
        }

    }
}
