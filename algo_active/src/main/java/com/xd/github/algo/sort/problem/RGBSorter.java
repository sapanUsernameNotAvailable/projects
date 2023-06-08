package com.xd.github.algo.sort.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RGBSorter {

    /**
     * sorts {'R','G','R','B','R','G','B'} R<G<B
     *
     * @param <T>
     * @param a
     * @param c
     */
    public static void main(String[] a) {
        List<String> input = new ArrayList<>(Arrays.asList("R", "G", "R", "B", "R", "G", "B"));
        Collections.sort(input, (o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            }
            // non equal case
            if (o1.equals("R")) {
                return -1;
            }
            if (o1.equals("B")) {
                return +1;
            }
            // G case
            if (o2.equals("R")) {
                return +1;
            }
            if (o2.equals("B")) {
                return -1;
            }
            // bug catching
            throw new RuntimeException("problematic coding for o1 = " + o1 + ", o2 = " + o2);
        });
        System.out.println(input);
    }
}
