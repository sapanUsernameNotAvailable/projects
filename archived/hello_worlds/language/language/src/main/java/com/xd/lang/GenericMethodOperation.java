package com.xd.lang;

import java.util.Collection;

public class GenericMethodOperation {

    public static <T> T addAndReturn(T entry, Collection<T> collection) {
        collection.add(entry);
        return entry;
    }
}
