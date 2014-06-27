package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
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
    Shape shape;
    shape = model.getCurrentShape();
    if(shape != null) {
      shape.draw(g);
    }
    System.out.println(model);
    System.out.println(shape);
  }
  
  public void resetComponents() {
    mainPanel.resetComponents();
    choicePanel.resetComponents();
  }

}

