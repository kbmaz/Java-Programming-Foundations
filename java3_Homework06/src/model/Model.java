package model;

import java.awt.Container;
import interfaces.Resettable;

public class Model implements Resettable {
  private Container container;
  private Container view;
  private String message;
  
  public static String[] selections = {"Line", "Rectangle", "Oval"};
  
  public final static String LINE = "Line";
  public final static String RECTANGLE = "Rectangle";
  public final static String OVAL = "Oval";
  
  public String currentShapeType = LINE;

  public final static String DRAW = "Draw";
  public final static String MOVE = "Move";
  public final static String RESIZE = "Resize";
  public final static String REMOVE = "Remove";
  public final static String CHANGE = "Change";
  public final static String FILL = "Fill";
  
  public String action = DRAW;
  private boolean fill = false;
  
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
    fill = false;
    if(container instanceof Resettable) {
      ((Resettable) container).resetComponents();
    }

  }
  
  public void setMessage(String msg) {
    this.message = msg;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getCurrentShapeType() {
    return currentShapeType;
  }

  public void setCurrentShapeType(String currentShapeType) {
    this.currentShapeType = currentShapeType;
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
