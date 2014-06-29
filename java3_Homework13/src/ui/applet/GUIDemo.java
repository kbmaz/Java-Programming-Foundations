package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;

import ui.panels.ControlsPanel;
import ui.panels.MainPanel;
import ui.panels.ChoicePanel;
import model.Model;
import java.awt.Graphics;
import java.util.*;

import shapes.Shape;
import event.ShapeMouseHandler;

public class GUIDemo extends Applet implements Resettable{
  
  Model model;
  MainPanel mainPanel;
  ChoicePanel choicePanel;
  
  public void init() {
    resize (600,400);
    model = new Model(this, this);
    mainPanel = new MainPanel(model);
    add(mainPanel);  
    choicePanel = new ChoicePanel(model);
    this.add(choicePanel);
    
    ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
    addMouseListener(mouseHandler);
    addMouseMotionListener(mouseHandler);
  }
  
  public void paint(Graphics g) {
    List<Shape> shapes;
    shapes = model.getShapeArrayList();
    for(Shape element : shapes) {
      if(element != null) {
        element.draw(g);
    }
  }
    System.out.println(model);
  }
  
  public void resetComponents() {
    mainPanel.resetComponents();
    choicePanel.resetComponents();
    
  }

}

