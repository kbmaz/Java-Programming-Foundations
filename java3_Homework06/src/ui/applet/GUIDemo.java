package ui.applet;

import interfaces.Resettable;
import java.applet.Applet;
import ui.panels.MainPanel;
import ui.panels.ChoicePanel;
import model.Model;
import java.awt.Graphics;

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
  }
  
  public void paint(Graphics g) {
    System.out.println(model);
    g.drawString(model.getMessage(), 20, 100);
  }
  
  public void resetComponents() {
    mainPanel.resetComponents();
    choicePanel.resetComponents();
  }

}
