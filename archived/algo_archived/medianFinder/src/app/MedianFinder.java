package app;

import java.util.Collections;
import java.util.List;

public class MedianFinder<T extends Comparable<T>> {

    // returns one of the medians if list even sized
    public T getAMedian(List<T> comparablesList) {
        Collections.sort(comparablesList);
        return comparablesList.get(comparablesList.size()/2);
    }
    
}
