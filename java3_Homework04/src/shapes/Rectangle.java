package shapes;
import java.awt.Color;

public class Rectangle extends Shape {
  private int h, w;  
  private Color fillColor;
  
  Rectangle(int x, int y, int h, int w, Color lineColor, Color fillColor) {
    
    super(x, y, lineColor);
    this.h = h;
    this.w = w;
    this.fillColor = fillColor;
  }

  public int getH() {
    return h;
  }

  public void setH(int h) {
    this.h = h;
  }

  public int getW() {
    return w;
  }

  public void setW(int w) {
    this.w = w;
  }

  public Color getFillColor() {
    return fillColor;
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }
}

  
  