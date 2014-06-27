package shapes;
import java.awt.*;

public abstract class Shape {
  
  private int x = 0;
  private int y = 0;
  private Color lineColor;
 

  public Shape(int x, int y, Color lineColor) {
    
    x = setX(x);
    y = setY(y);
    lineColor = setLineColor(lineColor);
  }
  
  public abstract void draw();
  
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
