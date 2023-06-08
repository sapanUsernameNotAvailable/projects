package com.xd.lang.collections;

import com.xd.lang.PrintingIterableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {
    
    @Test
    public void testIteratorCRUD() {

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.stream().forEach(System.out::println);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals(2)) {
                iterator.remove();
            }
        }

        Assert.assertTrue(list.get(0).equals(1));
        Assert.assertTrue(list.get(1).equals(3));
        Assert.assertEquals(list.size(), 2);
    }
    
    @Test
    public void testPrintingIterator() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PrintingIterableList<Integer> printingList = new PrintingIterableList(list);
        for (Integer loopVariable : printingList) {
            // Just iterate, the printing logic is in the iterator. 
            // Outside of dojo, it's not a good idea do this and bind such behaviour where it does not belong.
        }
    }
}
