package com.xd.github.algo.merge;

public class Merger<T extends Comparable<T>> {
    
    /**
     * Problem : 
     * 
     * Given 2 sorted arrays where first has m elements and size m+n
     * and second array has n elements and size n, 
     * modify first array to contain elements from second array as well
     * so that all elements in first array are in sorted order.
     * 
     * @param mPlusNArray
     * @param nArray 
     */
    public void merger(T[] mPlusNArray, T[] nArray) {
        /**
         * Algorithm : 
         * 
         * 1. iterate over m+n array's first m elements from last to beginning.
         * 2. iterate over n array's elements from last to start.
         * 3. merge 1. and 2.'s elements and get maximum result element.
         * 4. put result of 3 in m+n array in positions starting from end of array to beginning.
         * 5. do till elements in either array run out.
         * 6. fill remaining positions with leftover array elements.
         */
        
        final int n = nArray.length;
        final int m = mPlusNArray.length - n;
        
        int currentArray1index = m-1;
        int currentArray2index = n-1;
        int positionToFill = m+n - 1;
        
        while (currentArray1index != -1 && currentArray2index != -1) {
            T firstArrayElement = mPlusNArray[currentArray1index];
            T secondArrayElement = nArray[currentArray2index];

            if (firstArrayElement.compareTo(secondArrayElement) > 0) {
                mPlusNArray[positionToFill] = firstArrayElement;
                currentArray1index--;
            } else {
                mPlusNArray[positionToFill] = secondArrayElement;
                currentArray2index--;
            }
            positionToFill--;
        }
        
        if (currentArray1index == -1 && currentArray2index != -1) {
            reverseFillArray1FromArray2(mPlusNArray, nArray, currentArray2index, positionToFill);
        }
        
        if (currentArray2index == -1 && currentArray1index != -1) {
            reverseFillArray1FromArray2(mPlusNArray, mPlusNArray, currentArray1index, positionToFill);
        }
    }
    
    private void reverseFillArray1FromArray2(T[] array1, T[] array2, int currentArray2index, int array1positionToFill) {
        while (currentArray2index != -1) {
            array1[array1positionToFill] = array2[currentArray2index];
            currentArray2index--;
            array1positionToFill--;
        }
    }
    
}
