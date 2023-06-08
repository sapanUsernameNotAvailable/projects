package com.xd.github.algo.overlapping;

import com.xd.github.ds.Range;
import com.xd.github.ds.Coordinate;
import com.xd.github.ds.Rectangle;

public class Solver {

     /**
      * Finds if rectangles overlap.<br/>
      * Strategy : if even one vertex of one rectangle lies inside another rectangle, then rectangles do overlap
      *
      * @param r1 rectangle 1
      * @param r2 rectangle 2
      * @return true if rectangles overlap else false.
      */
     public boolean doRectanglesOverlap(Rectangle r1, Rectangle r2) {
          return isCoordinateInRectangle(r1, r2.getBottomLeft())
                  || isCoordinateInRectangle(r1, r2.getBottomRight())
                  || isCoordinateInRectangle(r1, r2.getTopLeft())
                  || isCoordinateInRectangle(r1, r2.getTopRight());
     }
     
     /**
      * Tests if coordinate inside rectangle<br/>
      * Strategy : Coordinate in rectangle if it lies within vertical limits AND horizontal limits
      *
      * @param rectangle rectangle
      * @param coordinate coordinate
      * @return true if coordinate inside rectangle else false
      */
     private boolean isCoordinateInRectangle(Rectangle rectangle, Coordinate coordinate) {

          return isPointInRange(rectangle.getXRange(), coordinate.getX())
                  && isPointInRange(rectangle.getYRange(), coordinate.getY());
     }
     
     /**
      * Tests if point within a range<br/>
      * Strategy: if |distance| of point from both extremes <= |segment length|, then point in range
      * 
      * @param range
      * @param point
      * @return true if point in range
      */
     private boolean isPointInRange(final Range range, final Number point) {

          double distanceFromFirstExtreme = Math.abs(range.getFirstExtreme().doubleValue() - point.doubleValue());
          double distanceFromSecondExtreme = Math.abs(range.getSecondExtreme().doubleValue() - point.doubleValue());

          return distanceFromFirstExtreme <= range.getLength().doubleValue()
                  && distanceFromSecondExtreme <= range.getLength().doubleValue();
     }
}