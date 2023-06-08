package com.xd.github.ds;

public class Rectangle{
     
     Number topX;
     Number botX;
     Number topY;
     Number botY;

     public Rectangle(Number topX, Number botX, Number topY, Number botY) {
          super();
          this.topX = topX;
          this.botX = botX;
          this.topY = topY;
          this.botY = botY;
     }
     
     public Coordinate getTopLeft() {
          return new Coordinate(topX, botY);
     }
     
     public Coordinate getTopRight() {
          return new Coordinate(topX, topY);
     }
     
     public Coordinate getBottomLeft() {
          return new Coordinate(botX, botY);
     }
     
     public Coordinate getBottomRight() {
          return new Coordinate(topX, botY);
     }
     
     public Range getXRange() {
          return new Range(botX, topX);
     }
     
     public Range getYRange() {
          return new Range(botY, topY);
     }
     

     public Number getNumberopX() {
          return topX;
     }

     public Number getBotX() {
          return botX;
     }

     public Number getNumberopY() {
          return topY;
     }

     public Number getBotY() {
          return botY;
     }
     
}
