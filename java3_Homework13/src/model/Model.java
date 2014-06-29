package model;

import java.awt.Color;
import shapes.Oval;
import shapes.Line;
import shapes.Rectangle;
import shapes.Triangle;
import shapes.Shape;
import java.awt.Container;
import interfaces.Resettable;
import java.util.*;

public class Model implements Resettable {
  private Container container;
  private Container view;
  private String message;
  private List<Shape> shapeArrayList = new ArrayList<Shape>();
  
  public static String[] selections = {"Rectangle", "Oval", "Line", "Triangle"};
  
  public enum Action {DRAW, MOVE, RESIZE, REMOVE, CHANGE, FILL};
  public enum ShapeType {RECTANGLE, OVAL, LINE, TRIANGLE};
  
  public final static String BLACK = "Black";
  public final static String RED = "Red";
  public final static String ORANGE = "Orange";
  public final static String YELLOW = "Yellow";
  public final static String GREEN = "Green";
  public final static String BLUE = "Blue";
  public final static String MAGENTA = "Magenta";
  public final static String GRAY = "Gray";
  
  private String currentLineColor = BLACK;
  private String currentFillColor = BLACK;
  private ShapeType currentShapeType = ShapeType.RECTANGLE;
  private Shape currentShape;
  
  public Action action = Action.DRAW;
  private boolean fill = false;
  
  private Color lColor;
  private Color fColor;
 
  public Shape createShape() {
    if (currentShapeType == ShapeType.RECTANGLE) {
      lColor = lineColor(currentLineColor);
      fColor = fillColor(currentFillColor);
      currentShape = new Rectangle (0, 0, 0, 0, getLColor(), getFColor(), fill);
    }
    if (currentShapeType == ShapeType.OVAL){
      lColor = lineColor(currentLineColor);
      fColor = fillColor(currentFillColor);
      currentShape = new Oval (0, 0, 0, 0, getLColor(), getFColor(), fill);
    }
    if (currentShapeType == ShapeType.TRIANGLE) {
      lColor = lineColor(currentLineColor);
      fColor = fillColor(currentFillColor);
      currentShape = new Triangle (0, 0, 0, 0, getLColor(), getFColor(), fill);
    }
    if (currentShapeType == ShapeType.LINE) {
      lColor = lineColor(currentLineColor);
      currentShape = new Line (0, 0, 0, 0, getLColor()); 
    }
    shapeArrayList.add(currentShape);
    
    return currentShape;
  }
  
  public Shape returnSelectShape(int xClk, int yClk) {
    for(Shape element : shapeArrayList) {
      if(element.containsLocation(xClk, yClk)) {
        return element;
      }
    }
    return null;
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
    action = Action.DRAW;
    currentShape = null;
    fill = false;
    currentLineColor = BLACK;
    currentFillColor = BLACK;
    
    shapeArrayList.clear();
    
    if(container instanceof Resettable) {
      ((Resettable)container).resetComponents();
    }
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
  
  public void setCurrentShape(Shape currentShape) {
    this.currentShape = currentShape;
  }
  
  public ShapeType getCurrentShapeType() {
    return currentShapeType;
  }

  public void setCurrentShapeType(ShapeType currentShapeType) {
    this.currentShapeType = currentShapeType;
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

  public Action getAction() {
    return action;
  }
  public void setAction(Action action) {
    this.action = action;
  }

  public boolean isFill() {
    return fill;
  }
  public void setFill(boolean fill) {
    this.fill = fill;
  }
  
  public List<Shape> getShapeArrayList(){
    return shapeArrayList;
  }
  public void setShapeArrayList(List<Shape> shapeArrayList) {
    this.shapeArrayList = shapeArrayList;
  }
  
  public String toString() {
    return "Model:\n\tAction: " + action + "\n\tFill: " + fill + "\n\tShape: " + currentShapeType
        + "\n\tLineColor: " + currentLineColor + "\n\tFillColor: " + currentFillColor;
   }

}

