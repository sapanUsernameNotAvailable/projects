package com.xd.lang.generics;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class WildCardsTest {

    @Test
    public void testChildRefrenceReads() throws Exception {
        List<Integer> itegerList = new LinkedList<Integer>();
        itegerList.add(4);
        List<? extends Integer> refrence = itegerList;
        refrence.get(0);
    }

    @Test
    public void testParentRefrenceAdds() throws Exception {
        List<? super Integer> refrence = new LinkedList<Number>();
        refrence.add(new Integer(4));
    }

}
