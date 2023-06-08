package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) throws Exception {

        Random random = new Random();
        MedianFinder<Integer> finder = new MedianFinder<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i< 10 ; i++) {
            list.add(random.nextInt(100));
        }
        
        System.out.println("median : " + finder.getAMedian(list));
    }
}
