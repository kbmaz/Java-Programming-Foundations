package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
  
  private int width, height;
  private int[] xArray = new int[3];
  private int[] yArray = new int[3];
  private Color fillColor;
  private boolean fill;
  
  public Triangle(int x, int y, int w, int h, Color lineColor, Color fillColor, boolean fill) {
    super(x, y, lineColor);
    this.width = w;
    this.height = h;
    this.fillColor = fillColor;
    this.fill = fill;
  }
  
  public void draw(Graphics g) {
    xArray[0] = getX();
    xArray[1] = getX() + getWidth();
    xArray[2] = getX();
    
    yArray[0] = getY();
    yArray[1] = getY() + getHeight();
    yArray[2] = getY() + getHeight();
    
    //Save the state of the object before changing it.
    Color oldColor = g.getColor();
    if(isFill()) {
      g.setColor(getFillColor());
      g.fillPolygon(getxArray(), getyArray(), 3);
    }
    g.setColor(getLineColor());
    g.drawPolygon(getxArray(), getyArray(), 3);
    //Set the state back when done.
    g.setColor(oldColor);
  }
  
//Override abstract method containsLocation in the Shape class.
  public boolean containsLocation(int x, int y) {
    if (getX() <= x && getY() <= y && getX() + getWidth() >= x && getY() + getHeight() >= y) {
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
  
  public void fill() {
    
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }
  
  public int[] getxArray() {
    return xArray;
  }
  
  public void setxArray(int[] xArray) {
    this.xArray = xArray;
  }
  
  public int[] getyArray() {
    return yArray;
  }
  
  public void setyArray(int[] yArray) {
    this.yArray = yArray;
  }
  
  public int getArea() {
    int area;
    area = ((getWidth() * getHeight())/2);
    return area;
  }

  public Color getFillColor() {
    return fillColor;
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }
  
  public void setFill(boolean fill) {
    this.fill = fill;
  }
  
  public boolean isFill() {
    return fill;
  }
  
  public String toString() {
    return "Triangle \n\tx = " + getX() + "\n\ty = " + getY() +
           "\n\tw = " + getWidth() + "\n\th = " + getHeight() + "\n\ta = " + getArea();
  }
  
  

}
