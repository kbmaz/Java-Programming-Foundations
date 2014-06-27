package shapes;
import java.awt.*;

public class Line extends Shape {
     private int x2, y2;
  
     public Line(int x, int y, int x2, int y2, Color lineColor){
       
       super(x, y, lineColor);
       this.x2 = x2;
       this.y2 = y2;
     }
     
     public void draw() {
       
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

}
