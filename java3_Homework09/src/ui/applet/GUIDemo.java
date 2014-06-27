package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;

import ui.panels.ControlsPanel;
import ui.panels.MainPanel;
import ui.panels.ChoicePanel;
import model.Model;
import java.awt.Graphics;
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
    Shape[] shapes;
    shapes = model.getShapeArray();
    for(Shape element : shapes) {
    if(element != null) {
      element.draw(g);
    System.out.println(element);
    }
  }
    if((shapes[0] != null) && (shapes[1] != null)) {
      if(model.compareShapes() == 1) {
        System.out.println("Shape 1 has a greater area than shape 2.");
      }
      if(model.compareShapes() == 2) {
        System.out.println("Shape 2 has a greater area than shape 1.");
      }
      if(model.compareShapes() == 3) {
        System.out.println("Both shapes have equal areas.");
      }
      if ((model.compareShapes() == -1)) {
        System.out.println("These shapes cannot be compared.");
      }
    }
    System.out.println(model);
  }
  
  public void resetComponents() {
    mainPanel.resetComponents();
    choicePanel.resetComponents();
    
  }

}

