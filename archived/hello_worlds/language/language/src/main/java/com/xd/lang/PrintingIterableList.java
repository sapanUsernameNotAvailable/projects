package com.xd.lang;

import java.util.Iterator;
import java.util.List;

public class PrintingIterableList<T> implements Iterable<T> {

    private final List<T> backingList;
    public PrintingIterableList(List<T> backingList) {
        this.backingList = backingList;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new PrintingIterator(backingList.iterator());
    }
}