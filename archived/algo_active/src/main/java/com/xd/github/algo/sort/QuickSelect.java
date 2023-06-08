package com.xd.github.algo.sort;

import java.util.Arrays;

public class QuickSelect<T extends Comparable<T>> {

    public int getKSmallestPosition(T[] arr, final int k) {

        if (k >= arr.length) {
            throw new IllegalArgumentException("current array : " + Arrays.toString(arr) + ", k : " + k);
        }

        int pivotIndex = getRandomPivot(arr.length);
        int pivotFinalIndex = sortAround(arr, pivotIndex);

        if (k == pivotFinalIndex) {
            return pivotFinalIndex;
        } else if (k < pivotFinalIndex) {
            return getKSmallestPosition(Arrays.copyOf(arr, pivotFinalIndex), k); 
        } else {
            int indexInNewArray = k - pivotFinalIndex -1;
            return pivotFinalIndex + getKSmallestPosition(Arrays.copyOfRange(arr, pivotFinalIndex + 1, arr.length),
                    indexInNewArray);
        }
    }

    private int getRandomPivot(int len) {
        double random = Math.random();
        int randomIndex = (int) Math.floor(len * random);

        if (randomIndex >= len) {
            throw new IllegalArgumentException("randomIndex : " + randomIndex + ", len : " + len);
        }
        return randomIndex;
    }

    public int sortAround(T[] arr, int pivotIndex) {

        if (pivotIndex >= arr.length) {
            throw new IllegalArgumentException("pivotIndex : " + pivotIndex + ", arr.length : " + arr.length);
        }

        T pivotValue = arr[pivotIndex];
        int endIndex = arr.length - 1;
        swap(arr, endIndex, pivotIndex);

        int lessThanPivotCounter = 0;

        for (int currentIndex = 0; currentIndex < endIndex; currentIndex++) {
            T currEntry = arr[currentIndex];
            if (currEntry.compareTo(pivotValue) < 0) {
                swap(arr, lessThanPivotCounter, currentIndex);
                lessThanPivotCounter++;
            }
        }

        swap(arr, endIndex, lessThanPivotCounter);
        return lessThanPivotCounter;
    }

    private void swap(T[] arr, int i, int j) {
        T holder = arr[i];
        arr[i] = arr[j];
        arr[j] = holder;
    }
}
