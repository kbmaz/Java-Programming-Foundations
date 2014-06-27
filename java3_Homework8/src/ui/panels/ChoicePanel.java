package ui.panels;

import interfaces.Resettable;

import java.awt.Choice;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.Model;

public class ChoicePanel extends Panel implements Resettable {
  
  Model model;
  Choice selection;
  
  
  public ChoicePanel(Model mdl) {
    model = mdl;
    selection = new Choice();
    
    
    for (String msg: Model.selections) {
      selection.add(msg);
    }
    selection.addItemListener(new ItemListener() {
      
      public void itemStateChanged(ItemEvent e) {
        model.setMessage(selection.getSelectedItem());
        model.setCurrentShapeType(selection.getSelectedItem());
        model.repaint();
      }
    });
    this.add(selection);
    
  }
  
  public void resetComponents() {
    selection.select(0);
    model.setMessage(selection.getSelectedItem());
    
  }

}
