package model;

import java.awt.Color;
import shapes.Oval;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;
import java.awt.Container;
import interfaces.Resettable;
import interfaces.ComparableShape;

public class Model implements Resettable {
  private Container container;
  private Container view;
  private String message;
  
  public static String[] selections = {"Rectangle", "Oval", "Line"};
  
  public final static String BLACK = "Black";
  public final static String RED = "Red";
  public final static String ORANGE = "Orange";
  public final static String YELLOW = "Yellow";
  public final static String GREEN = "Green";
  public final static String BLUE = "Blue";
  public final static String MAGENTA = "Magenta";
  public final static String GRAY = "Gray";
  
  public final static String LINE = "Line";
  public final static String RECTANGLE = "Rectangle";
  public final static String OVAL = "Oval";
  
  private String currentLineColor = BLACK;
  private String currentFillColor = BLACK;
  private String currentShapeType = RECTANGLE;
  private Shape currentShape;
  private Shape[] shapeArray = new Shape[2];

  public final static String DRAW = "Draw";
  public final static String MOVE = "Move";
  public final static String RESIZE = "Resize";
  public final static String REMOVE = "Remove";
  public final static String CHANGE = "Change";
  public final static String FILL = "Fill";
  
  public String action = DRAW;
  private boolean fill = false;
  
  private Color lColor;
  private Color fColor;
 
  public Shape createShape() {
    if (currentShapeType == RECTANGLE) {
      lColor = lineColor(currentLineColor);
      fColor = fillColor(currentFillColor);
      currentShape = new Rectangle (0, 0, 0, 0, getLColor(), getFColor(), fill);
    }
    if (currentShapeType == OVAL){
      lColor = lineColor(currentLineColor);
      fColor = fillColor(currentFillColor);
      currentShape = new Oval (0, 0, 0, 0, getLColor(), getFColor(), fill);
    }
    if (currentShapeType == LINE) {
      lColor = lineColor(currentLineColor);
      currentShape = new Line (0, 0, 0, 0, getLColor()); 
    }
    if((shapeArray[0] != null) && (shapeArray[1] != null)) {
      shapeArray = new Shape[2];
    }
    if(shapeArray[0] == null) {
      shapeArray[0] = getCurrentShape();
    }
    else if (shapeArray[1] == null) {
      shapeArray[1] = getCurrentShape();
    }
    return currentShape;
  }
     
  public Model (Container container, Container view) {
    this.container = container;
    this.view = view;
    message = selections[0];
  }
  
  public void repaint() {
    container.repaint();
    view.repaint();
  }
  
  public void resetComponents() {
    
    ((Resettable)view).resetComponents();
    repaint();
    action = DRAW;
    currentShape = null;
    fill = false;
    currentLineColor = BLACK;
    currentFillColor = BLACK;
    
    for (int i = 0; i < shapeArray.length; i++) {
      shapeArray[i] = null;
    }
    if(container instanceof Resettable) {
      ((Resettable) container).resetComponents();
    }
  }
  
  public int compareShapes() {

    if ((shapeArray[0] instanceof ComparableShape) && (shapeArray[1] instanceof ComparableShape)) {
      int area1 = ((ComparableShape)shapeArray[0]).getArea();
      int area2 = ((ComparableShape)shapeArray[1]).getArea();
      
      if (area1 > area2) return 1;
      if (area1 < area2) return 2;
      if (area1 == area2)return 3;   
    }
    else {
    return -1;
    }
    return 0;
  }
  
  public Color lineColor(String currentLineColor) {
    if(currentLineColor == BLACK) {
      lColor = Color.black;
    }
    if(currentLineColor == GRAY) {
      lColor = Color.gray;
    }
    if(currentLineColor == RED) {
      lColor = Color.red;
    }
    if(currentLineColor == ORANGE) {
      lColor = Color.orange;
    }
    if(currentLineColor == YELLOW) {
      lColor = Color.yellow;
    }
    if(currentLineColor == GREEN) {
      lColor = Color.green;
    }
    if(currentLineColor == BLUE) {
      lColor = Color.blue;
    }
    if(currentLineColor == MAGENTA) {
      lColor = Color.magenta;
    }
    return lColor;
  }
  
  public Color fillColor(String currentFillColor) {
    if(currentFillColor == BLACK) {
      fColor = Color.black;
    }
    if(currentFillColor == GRAY) {
      fColor = Color.gray;
    }
    if(currentFillColor == RED) {
      fColor = Color.red;
    }
    if(currentFillColor == ORANGE) {
      fColor = Color.orange;
    }
    if(currentFillColor == YELLOW) {
      fColor = Color.yellow;
    }
    if(currentFillColor == GREEN) {
      fColor = Color.green;
    }
    if(currentFillColor == BLUE) {
      fColor = Color.blue;
    }
    if(currentFillColor == MAGENTA) {
      fColor = Color.magenta;
    }
    return fColor;
  }
  public void setMessage(String msg) {
    this.message = msg;
  }
  
  public String getMessage(String msg) {
    return this.message;
  }
    
  public Shape getCurrentShape() {
    return currentShape;
  }
  
  public String getCurrentShapeType() {
    return currentShapeType;
  }

  public void setCurrentShapeType(String shapeType) {
    currentShapeType = shapeType;
  }
  
  public Shape[] getShapeArray() {
    return shapeArray;
  }
  public void setShapeArray(Shape[] shapeArray) {
    this.shapeArray = shapeArray;
  }
  
  public Color getLColor() {
    return lColor; 
  }
  public void setLColor(Color lColor) {
    this.lColor = lColor;
  }
  
  public Color getFColor() {
    return fColor; 
  }  
  public void setFColor(Color fColor) {
    this.fColor = fColor;
  }
  
  public String getCurrentLineColor() {
    return currentLineColor; 
  }  
  public void setCurrentLineColor(String currentLineColor) {
    this.currentLineColor = currentLineColor;
  }
  
  public String getCurrentFillColor() {
    return currentFillColor; 
  } 
  public void setCurrentFillColor(String currentFillColor) {
    this.currentFillColor = currentFillColor;
  }

  public String getAction() {
    return action;
  }
  public void setAction(String action) {
    this.action = action;
  }

  public boolean isFill() {
    return fill;
  }
  public void setFill(boolean fill) {
    this.fill = fill;
  }
  
  public String toString() {
    return "Model:\n\tAction: " + action + "\n\tFill: " + fill + "\n\tShape: " + currentShapeType
        + "\n\tLineColor: " + currentLineColor + "\n\tFillColor: " + currentFillColor;
  }

}

