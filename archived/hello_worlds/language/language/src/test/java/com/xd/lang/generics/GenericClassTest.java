package com.xd.lang.generics;

import com.xd.lang.GenericMethodOperation;
import com.xd.lang.GenericFactory;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test; 

public class GenericClassTest {

    @Test
    public void testGenericClass () throws Exception {
        Class<String> factoryClassType = String.class;
        Object factoryOutput = new GenericFactory(factoryClassType).getInstance();
        Assert.assertTrue(factoryOutput.getClass().getSimpleName().equals("String"));
    }
    
    @Test
    public void testGenericMethod () throws Exception {
        List<Integer> listCollection = new LinkedList<>();
        Assert.assertTrue(GenericMethodOperation.addAndReturn(1, listCollection).equals(1));
        List<String> stringCollection = new LinkedList<>();
        Assert.assertTrue(GenericMethodOperation.addAndReturn("a", stringCollection).equals("a"));
    }
}
