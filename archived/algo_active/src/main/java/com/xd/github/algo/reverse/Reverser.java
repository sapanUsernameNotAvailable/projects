package com.xd.github.algo.reverse;

import com.xd.github.ds.LinkedNode;
import java.util.List;

public class Reverser {

    /**
     * swaps entries at opposite ends of the list
     *
     * @param <T>
     * @param list
     * @return
     */
    public <T> List<T> reverse(List<T> list) {

        if (list == null) {
            throw new IllegalArgumentException("null list");
        } else if (list.isEmpty()) {
            return list;
        }

        int beginIndex = 0;
        int endIndex = list.size() - 1;

        while (beginIndex < endIndex) {

            // swap
            T beginValue = list.get(beginIndex);
            T endValue = list.get(endIndex);
            list.set(beginIndex, endValue);
            list.set(endIndex, beginValue);

            beginIndex++;
            endIndex--;
        }

        return list;
    }

    public <T> LinkedNode<T> reverse(LinkedNode<T> beginNode) {

        if (beginNode == null) {
            throw new IllegalArgumentException("null list");
        }
        if (beginNode.getNext() == null) {
            return beginNode;
        }

        // first node handling
        LinkedNode<T> firstNode = beginNode;
        LinkedNode<T> secondNode = beginNode.getNext();
        firstNode.setNext(null);


        LinkedNode<T> thirdNode = secondNode.getNext();
        while (thirdNode != null) {
            
            // pointer change
            secondNode.setNext(firstNode);
            // next triplet assignment
            firstNode = secondNode;
            secondNode = thirdNode;
            thirdNode = thirdNode.getNext();

        }
        secondNode.setNext(firstNode);
        return secondNode;
    }
}
