package shapes;

import java.awt.*;
import interfaces.ComparableShape;

public abstract class Shape implements ComparableShape {
  
  private int x, y;
  private Color lineColor;
 

  public Shape(int x, int y, Color lineColor) {
    
    x = setX(x);
    y = setY(y);
    lineColor = setLineColor(lineColor);
  }
  
  public abstract void draw(Graphics g);
  public abstract boolean containsLocation(int x, int y);
  
  public abstract void move();
  
  public abstract void resize();
  
  public abstract void remove();
  
  public abstract void change();
  
  public abstract void clear();
  
  public void fill() {
    
  }
     
  public int getX() {
    return x;
  }

  public int setX(int x) {
    return this.x = x;
  }

  public int getY() {
    return y;
  }

  public int setY(int y) {
    return this.y = y;
  }

  public Color getLineColor() {
    return lineColor;
  }

  public Color setLineColor(Color lineColor) {
    return this.lineColor = lineColor;
  }

}
