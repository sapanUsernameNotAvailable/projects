package com.xd.lang;

import java.util.Iterator;

public class PrintingIterator<T> implements Iterator<T> {
    
    private final Iterator<T> backingIterator;
    
    PrintingIterator(Iterator<T> backingIterator) {
        this.backingIterator = backingIterator;
    }

    @Override
    public boolean hasNext() {
        return backingIterator.hasNext();
    }

    @Override
    public T next() {
        T next = backingIterator.next();
        System.out.println("Next object : " + next);
        return next;
    }
}