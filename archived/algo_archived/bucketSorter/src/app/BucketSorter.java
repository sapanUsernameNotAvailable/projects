package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  we need evaluable to decide the bucket
 *  see {@link BucketSorter#getBucketNumberForNode(Evaluable)}
 */
public class BucketSorter <T extends  Evaluable> {

    final ArrayList<List<T>> allTheBuckets = new ArrayList<List<T>>();
    final int bucketRangeSize;
    final int maxAllowableValue;
    
    BucketSorter(int bucketRangeSize, int maxAllowableValue) {
        this.bucketRangeSize = bucketRangeSize;
        this.maxAllowableValue = maxAllowableValue;
        
        // arraylist don't allow inserting at random index if the array list size is smaller than the index.
        // so you need to have something upto that index
        // you could try filling upto that index when you add a new element
        // but then you'll have to get the existing size and then fill elements from the size onwards till the index
        // that is going to give better performance but won't change the O(n) complexity.
        // Until its my production sys, I prefer keeping the code clean over that performance.
        
        for (int i = 0; i < getTotalBuckets() ; i++) {
            allTheBuckets.add(new ArrayList<T>());
        }
    }
    
    public void addIntoSomeBucket(final T node) {
        if (node.getValue() > maxAllowableValue) {
            throw new IndexOutOfBoundsException("Your node's value exceeds bucket capacity");
        }
        
        List<T> existingBucketForNode = allTheBuckets.get(getBucketNumberForNode(node));
        existingBucketForNode.add(node);
    }
    
    
    private int getBucketNumberForNode(T node) {
        return node.getValue() / bucketRangeSize;
    }
        
    public List<T> getSortedNodesFromAllBuckets() {
        
        List<T> sortedNodesFromAllBuckets = new ArrayList<T>();
        
        for (List<T> bucket : allTheBuckets) {
            Collections.sort(bucket, new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    if (o1.getValue() < o2.getValue()) {
                        return -1;
                    } else if (o1.getValue() > o2.getValue()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            sortedNodesFromAllBuckets.addAll(bucket);
        }
        
        return sortedNodesFromAllBuckets;
    }
    
    private int getTotalBuckets() {
            return 2 + (maxAllowableValue/bucketRangeSize); // off by one, then some. 
    }
}