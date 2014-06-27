package shapes;
import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
     private int x2, y2;
  
     public Line(int x, int y, int x2, int y2, Color lineColor){
       
       super(x, y, lineColor);
       this.x2 = x2;
       this.y2 = y2;
     }
     
     public void draw(Graphics g) {
     //Save the state of the object before changing it.
       Color oldColor = g.getColor();
       g.setColor(getLineColor());
       g.drawLine(getX(), getY(), getX2(), getY2());
       //Set the state back when done.
       g.setColor(oldColor);
     }

     public boolean containsLocation(int x, int y) {
       if (getX() <= x && getY() <= y && getX() + getX2() >= x && getY() + getY2() >= y) {
         return true;
       }
       return false;
     }
     
     public void move() {
       
     }
     
     public void resize() {
       
     }
     
     public void remove() {
       
     }
     
     public void change() {
       
     }
     
     public void clear() {
       
     }

    public int getX2() {
      return x2;
    }

    public void setX2(int x2) {
      this.x2 = x2;
    }

    public int getY2() {
      return y2;
    }

    public void setY2(int y2) {
      this.y2 = y2;
    }
    
    public int getArea() {
      return 0;
    }
    
    /** 
     * Returns a String representing this object.
     */
    public String toString() {
      return "Line: \n\tx = " + getX() + "\n\ty = " + getY() +
          "\n\tx2 = " + getX2() + "\n\ty2 = " + getY2();
    }

}
