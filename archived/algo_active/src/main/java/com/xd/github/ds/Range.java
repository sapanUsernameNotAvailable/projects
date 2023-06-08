package com.xd.github.ds;

public class Range{
     
     Number firstExtreme;
     Number secondExtreme;
     Number length;

     public Range(Number firstExtreme, Number secondExtreme) {
          this.firstExtreme = firstExtreme;
          this.secondExtreme = secondExtreme;
          this.length = Math.abs(firstExtreme.doubleValue() - secondExtreme.doubleValue());
     }
     
     public Number getLength() {
          return length;
     }

     public Number getFirstExtreme() {
          return firstExtreme;
     }

     public Number getSecondExtreme() {
          return secondExtreme;
     }
}
