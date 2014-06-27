/*package ui.panels;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import interfaces.Resettable;
import model.Model;
import ui.panels.ButtonPanel;

public class ControlsPanel extends Panel implements Resettable {
  
  private static Model model;
  //private static Choice lineColor;
  //private static Choice fillColor;
  //private static Choice lineColorSelections;
  //private static Choice fillColorSelections;
  
  private static Color defaultLineColor = Color.black;
  private static Color defaultFillColor = Color.black;
  
  private ColorPanelClass colorChoice;
  
  public void init() {
   colorChoice = new ColorPanelClass();
  }
  
  
  private ColorPanel clrPanel;
  private ButtonPanel btnPanel;
  
  
  public ControlsPanel(Model model) {
    btnPanel = new ButtonPanel(model);
    add(btnPanel);
  }
  
  public static class ColorPanel { 
    
    model = mdl;
    lineColorSelections = new Choice();
    fillColorSelections = new Choice();
    
    for (String msg: Model.lineColorSelections) {
      lineColorSelections.add(msg);
    }
    lineColorSelections.addItemListener(new ItemListener() {
      
      public void itemStateChanged(ItemEvent e) {
        model.setMessage(lineColorSelections.getSelectedItem());
        model.setCurrentShapeLineColor(lineColorSelections.getSelectedItem());
        model.repaint();
      }
    });
    this.add(lineColorSelections);
    
    for (String msg: Model.fillColorSelections) {
      fillColorSelections.add(msg);
    }
    fillColorSelections.addItemListener(new ItemListener() {
      
      public void itemStateChanged(ItemEvent e) {
        model.setMessage(fillColorSelections.getSelectedItem());
        model.setCurrentShapeFillColor(fillColorSelections.getSelectedItem());
        model.repaint();
      }
    });
    this.add(fillColorSelections);
    
  }
    public static class ColorPanelClass {
    
    private Color lineColor;
    private Color fillColor;
    
    public Color getLineColor() {
      return lineColor;
    }
    public void setLineColor(Color lineColor) {
      this.lineColor = lineColor;
    }
    public Color getFillColor() {
      return fillColor;
    }
    public void setFillColor(Color fillColor) {
      this.fillColor = fillColor;
    }
    public ColorPanelClass() {
      lineColor = defaultLineColor;
      fillColor = defaultFillColor;
    }
  }

  public void resetComponents() {  
  }

    
}*/

