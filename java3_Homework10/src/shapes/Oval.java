package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rectangle {
  /**
   * Constructor. Just passes the params to the Rectangle constructor.
   */
  public Oval(int x, int y, int h, int w, Color lineColor, Color fillColor, boolean fill) {

    super(x, y, w, h, lineColor, fillColor, fill);
  }

  /*
   * Override Rectangle draw(Graphics g) method.
   */
  public void draw(Graphics g) {
    //Save state of the object before changing it.
    Color oldColor = g.getColor();
    if (isFill()) {
      g.setColor(getFillColor());
      g.fillOval(getX(), getY(), getW(), getH());
    }
    g.setColor(getLineColor());
    g.drawOval(getX(), getY(), getW(), getH());
      //Set the state back when done.
      g.setColor(oldColor);
    }
  
  public int getArea() {
    double area;
    area = ((getW()/2) * (getH()/2) * Math.PI);
    return(int)area;
  }
  
  /**
   * Returns a String that represents this object.
   */
  public String toString() {
    return "Oval: \n\tx = " + getX() + "\n\ty = " + getY() + "\n\tw = " + getW() + "\n\th = " + getH() + "\n\tarea = " + getArea();
  }

}
