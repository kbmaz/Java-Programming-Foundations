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
  
  Color lineColor;
  Color fillColor;
  
  public Color getFillColor() {
    return fillColor;
  }

  public Color getLineColor() {
    return lineColor;
  }

  public void setLineColor(Color lineColor) {
    this.lineColor = lineColor;
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = fillColor;
  }

  private ShapeType currentShapeType = ShapeType.RECTANGLE;
  private Shape currentShape;
  
  public Action action = Action.DRAW;
  private boolean fill = false;
 
  public Shape createShape() {
    if (currentShapeType == ShapeType.RECTANGLE) {
      
      currentShape = new Rectangle (0, 0, 0, 0, getLineColor(), getFillColor(), fill);
    }
    if (currentShapeType == ShapeType.OVAL){
      
      currentShape = new Oval (0, 0, 0, 0, getLineColor(), getFillColor(), fill);
    }
    if (currentShapeType == ShapeType.TRIANGLE) {
      
      currentShape = new Triangle (0, 0, 0, 0, getLineColor(), getFillColor(), fill);
    }
    if (currentShapeType == ShapeType.LINE) {
      
      currentShape = new Line (0, 0, 0, 0, getLineColor()); 
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
    lineColor = Color.BLACK;
    fillColor = Color.BLACK;
    
    shapeArrayList.clear();
    
    if(container instanceof Resettable) {
      ((Resettable)container).resetComponents();
    }
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
        + "\n\tLineColor: " + lineColor + "\n\tFillColor: " + fillColor;
   }

}

