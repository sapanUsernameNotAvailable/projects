package app;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        BucketSorter<Node> allTheBuckets = new BucketSorter<Node>(50, 700);
        
        Random random= new Random();
        for (int i = 0; i < 100; i++) {
            allTheBuckets.addIntoSomeBucket(new Node(random.nextInt(700)));    
        }
        
        List<Node> sortedNodes = allTheBuckets.getSortedNodesFromAllBuckets(); 
        System.out.println(sortedNodes);
    }
}
