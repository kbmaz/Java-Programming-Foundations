package shapes;
import java.awt.*;

public class Shape {
  
  private int x = 0;
  private int y = 0;
  private Color lineColor;
 

  public Shape(int x, int y, Color lineColor) {
    
    x = setX(x);
    y = setY(y);
    lineColor = setLineColor(lineColor);
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
