package com.xd.github.algo.misc.overlapping;

import com.xd.github.algo.overlapping.Solver;
import com.xd.github.ds.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTest {

     private static final Solver solver = new Solver();
     
      /**
       * +----------+----+
       * |     |    |    |
       * |     +----|----+
       * |          |
       * +----------+
       */
      @Test
      public void testTrue() {
           Rectangle r1 = new Rectangle(3, 1, 4, 2);
           Rectangle r2 = new Rectangle(4, 2, 4, 3);
           boolean result = solver.doRectanglesOverlap(r1, r2);
           assertTrue(result);
      }
      
      /**
       * 
       * +-----+    +----+
       * |     |    |    |
       * +-----+    +----+
       * 
       */
      @Test
      public void testFalse() {
           Rectangle r1 = new Rectangle(5.5, 4.3, 4, 2);
           Rectangle r2 = new Rectangle(4, 2, 4, 2);
           boolean result = solver.doRectanglesOverlap(r1, r2);
           assertFalse(result);
      }
}
