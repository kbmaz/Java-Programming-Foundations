package model;

import java.awt.Color;
import shapes.Oval;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;
import java.awt.Container;
import interfaces.Resettable;

public class Model implements Resettable {
  private Container container;
  private Container view;
  private String message;
  private String lineMessage;
  private String fillMessage;
  
  
  public static String[] lineColorSelections = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Pink"};
  public static String[] fillColorSelections = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Pink"};
  public static String[] selections = {"Rectangle", "Oval", "Line"};
  
  public final static String BLACK = "Black";
  public final static String RED = "Red";
  public final static String ORANGE = "Orange";
  public final static String YELLOW = "Yellow";
  public final static String GREEN = "Green";
  public final static String BLUE = "Blue";
  public final static String PURPLE = "Purple";
  public final static String PINK = "Pink";
  
  public final static String LINE = "Line";
  public final static String RECTANGLE = "Rectangle";
  public final static String OVAL = "Oval";
  
  private String currentShapeType = RECTANGLE;
  private Shape currentShape;

  public final static String DRAW = "Draw";
  public final static String MOVE = "Move";
  public final static String RESIZE = "Resize";
  public final static String REMOVE = "Remove";
  public final static String CHANGE = "Change";
  public final static String FILL = "Fill";
  
  public String action = DRAW;
  private boolean fill = false;
 
  public Shape createShape() {
    if (currentShapeType == RECTANGLE) {
      currentShape = new Rectangle (0, 0, 0, 0, Color.black, Color.red, fill);
    }
    else if (currentShapeType == OVAL){
      currentShape = new Oval (0, 0, 0, 0, Color.black, Color.red, fill);
    }
    else if (currentShapeType == LINE) {
      currentShape = new Line (0, 0, 0, 0, Color.black); 
    }
    return currentShape;
  }
    
  
  public Model (Container container, Container view) {
    this.container = container;
    this.view = view;
    message = selections[0];
    lineMessage = lineColorSelections[0];
    fillMessage = fillColorSelections[0];  
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
    if(container instanceof Resettable) {
      ((Resettable) container).resetComponents();
    }

  }
  
  public void setMessage(String msg) {
    this.message = msg;
  }
  
  public String getMessage(String msg) {
    return this.message;
  }
  
  public void setLineMessage(String msg) {
    this.message = msg;
  }
  
  public String getLineMessage(String msg) {
    return this.message;
  }
  
  public void setFillMessage(String msg) {
    this.message = msg;
  }
  
  public String getFillMessage(String msg) {
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
    return "Model:\n\tAction: " + action + "\n\tFill: " + fill;
  }

}

