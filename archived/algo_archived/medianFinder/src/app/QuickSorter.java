package app;

import java.util.Collections;
import java.util.List;

public class QuickSorter<T extends Comparable<T>> {

    public void sort(final List<T> sortableList) {

        if (sortableList == null) {
            throw new NullPointerException("null list");
        }
        if (sortableList.isEmpty() || sortableList.size() == 1) {
            return;
        }

        final int listSize = sortableList.size();
        T pivot = sortableList.get(listSize / 2);

        int lowerCounter = 0, upperCounter = listSize - 1;

        while (lowerCounter <= upperCounter) {

            while (sortableList.get(lowerCounter).compareTo(pivot) < 0) {
                lowerCounter++;
            }

            while (sortableList.get(upperCounter).compareTo(pivot) > 0) {
                upperCounter--;
            }
            if (lowerCounter <= upperCounter) {
                Collections.swap(sortableList, lowerCounter, upperCounter);
                lowerCounter++;
                upperCounter--;
            }
        }
        // Recursion
        if (0 < upperCounter)
            sort(sortableList.subList(0, upperCounter));
        if (lowerCounter < listSize)
            sort(sortableList.subList(lowerCounter, listSize));
    }

    public void verifier(List<T> sortedList) throws Exception {

        for (int i = 0; i < sortedList.size() - 2; i++) {
            if (sortedList.get(i).compareTo(sortedList.get(i + 1)) > 0) {
                throw new Exception("element " + sortedList.get(i) + " is greater than " + sortedList.get(i + 1));
            }
        }
    }
}