package ui.panels;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Label;

import interfaces.Resettable;
import model.Model;
import ui.panels.ButtonPanel;

public class ControlsPanel extends Panel implements Resettable {
  
  private static Model model;

  private ButtonPanel btnPanel;
  private ColorPanel clrPanel;
  
  private Label lineLabel;
  private Label fillLabel;
  
  private static Choice lineColor = new Choice();
  private static Choice fillColor = new Choice();
  
  public static String[] colorSelections = {"Black", "Red", "Orange", "Yellow", "Green", "Blue", "Gray", "Magenta"};
  
  public ControlsPanel(final Model model) {
    btnPanel = new ButtonPanel(model);
    clrPanel = new ColorPanel();
    lineLabel = new Label("Line");
    fillLabel = new Label("Fill");
    
    add(btnPanel);
    add(lineLabel);
    add(clrPanel.getLineColor());
    add(fillLabel);
    add(clrPanel.getFillColor());
    
    lineColor.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (lineColor.getSelectedItem() == "Black")
          model.setLineColor(Color.black);
        if (lineColor.getSelectedItem() == "Red")
          model.setLineColor(Color.red);
        if (lineColor.getSelectedItem() == "Orange")
          model.setLineColor(Color.orange);
        if (lineColor.getSelectedItem() == "Yellow")
          model.setLineColor(Color.yellow);
        if (lineColor.getSelectedItem() == "Green")
          model.setLineColor(Color.green);
        if (lineColor.getSelectedItem() == "Blue")
          model.setLineColor(Color.blue);
        if (lineColor.getSelectedItem() == "Gray")
          model.setLineColor(Color.gray);
        if (lineColor.getSelectedItem() == "Magenta")
          model.setLineColor(Color.magenta);
        
      }
    });
    
    fillColor.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (fillColor.getSelectedItem() == "Black")
          model.setFillColor(Color.black);
        if (fillColor.getSelectedItem() == "Red")
          model.setFillColor(Color.red);
        if (fillColor.getSelectedItem() == "Orange")
          model.setFillColor(Color.orange);
        if (fillColor.getSelectedItem() == "Yellow")
          model.setFillColor(Color.yellow);
        if (fillColor.getSelectedItem() == "Green")
          model.setFillColor(Color.green);
        if (fillColor.getSelectedItem() == "Blue")
          model.setFillColor(Color.blue);
        if (fillColor.getSelectedItem() == "Gray")
          model.setFillColor(Color.gray);
        if (fillColor.getSelectedItem() == "Magenta")
          model.setFillColor(Color.magenta);
      }
    });
  }
    
  public static class ColorPanel{
    public ColorPanel() {
      for(String choices : colorSelections) {
        lineColor.add(choices);
        fillColor.add(choices);
      }
    }
    public Choice getLineColor() {
      return lineColor;
    }
    public Choice getFillColor() {
      return fillColor;
    }
    public static String[] getColorSelections() {
      return colorSelections;
    }
  }

  public void resetComponents() {  
    lineColor.select(0);
    fillColor.select(0);
  }
  
  public ButtonPanel getBtnPanel() {
    return btnPanel;
  }
  public void setBtnPanel(ButtonPanel btnPanel) {
    this.btnPanel = btnPanel;
  }
    
}


  

