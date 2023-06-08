package com.xd.github.algo.reverse;

import com.xd.github.ds.LinkedNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    private static final Reverser reverser = new Reverser();

    // algorithm 1 tests follow
    
    @Test
    public void testIndexedList1() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 5, 3, 7, 4, 8));
        List<Integer> output = reverser.reverse(input);
        List<Integer> expected = new ArrayList<>(Arrays.asList(8, 4, 7, 3, 5, 1));
        Assert.assertEquals(expected, output);
    }


    @Test
    public void testIndexedList2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, -15, 3, 7, 4, 8));
        List<Integer> output = reverser.reverse(input);
        List<Integer> expected = new ArrayList<>(Arrays.asList(8, 4, 7, 3, -15, 1));
        Assert.assertEquals(expected, output);
    }

    
    // algorithm 2 tests follow
    
    @Test
    public void testSinglyLinkedList1() {
        LinkedNode<Integer> input = getLinkedNodes(1, 5, 3, 7, 4, 8);
        LinkedNode<Integer> output = reverser.reverse(input);
        LinkedNode<Integer> expected = getLinkedNodes(8, 4, 7, 3, 5, 1);
        Assert.assertEquals(expected, output);
    }
    
    @Test
    public void testSinglyLinkedList2() {
        LinkedNode<Integer> input = getLinkedNodes(1, -15, 3, 7, 4);
        LinkedNode<Integer> output = reverser.reverse(input);
        LinkedNode<Integer> expected = getLinkedNodes(4, 7, 3, -15, 1);
        Assert.assertEquals(expected, output);
    }
    @Test
    public void testSinglyLinkedListOneEntry() {
        LinkedNode<Integer> input = getLinkedNodes(4);
        LinkedNode<Integer> output = reverser.reverse(input);
        LinkedNode<Integer> expected = getLinkedNodes(4);
        Assert.assertEquals(expected, output);
    }
    
    @Test
    public void testSinglyLinkedListTwoEntry() {
        LinkedNode<Integer> input = getLinkedNodes(4, 7);
        LinkedNode<Integer> output = reverser.reverse(input);
        LinkedNode<Integer> expected = getLinkedNodes(7, 4);
        Assert.assertEquals(expected, output);
    }
    
    
    @Test
    public void testSinglyLinkedListThreeEntries() {
        LinkedNode<Integer> input = getLinkedNodes(4, 7, -8);
        LinkedNode<Integer> output = reverser.reverse(input);
        LinkedNode<Integer> expected = getLinkedNodes(-8, 7, 4);
        Assert.assertEquals(expected, output);
    }

    private <T> LinkedNode<T> getLinkedNodes(T... nodeValues) {
        if (nodeValues == null) {
            throw new IllegalArgumentException();
        }
        
        List<LinkedNode<T>>linkedNodes = new LinkedList<>();
        Stream.of(nodeValues).forEach(item ->  linkedNodes.add(new LinkedNode<>(item, null))); // hello java 8

        for(int i = 0; i< linkedNodes.size()-1;i++) {
            linkedNodes.get(i).setNext(linkedNodes.get(i+1));
        }
        
        return linkedNodes.get(0);
    }
}
