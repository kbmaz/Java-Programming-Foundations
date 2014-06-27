package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.Rectangle;
import shapes.Oval;
import shapes.Line;
import shapes.Shape;

public class ShapeMouseHandler extends MouseAdapter {
  private Model model;
  //Start x and y location used to mark where the upper left corner of a shape is.
  private int startX;
  private int startY;
  private Shape shape;
  
  /**
   * Constructor.  Sets the model for this Listener.
   * 
   * @param model
   */
   public ShapeMouseHandler(Model model) {
     //persist local variable model to this.model.
     this.model = model;
   }
   
   /*
    * OVerrides MouseAdapter mousePressed method.
    */
   public void mousePressed(MouseEvent e) {
     if (model.getAction() == Model.DRAW) {
       //original upper left x and y of the shape.
       startX = e.getX();
       startY = e.getY();
       //have the model create a new shape for us.
       shape = model.createShape();
       //if the shape was created.
       if(shape != null) {
         //set its upper left x and y to where the mouse was pressed.
         shape.setX(e.getX());
         shape.setY(e.getY());
         //Set a default width and height or ending location in case user does not drag mouse.
         //Currently only instances of Rectangle or its descendants are used.
         if (shape instanceof Rectangle) {
           ((Rectangle)shape).setW(50);
           ((Rectangle)shape).setH(50);
         }
         else if (shape instanceof Line) {
           ((Line)shape).setX2(50);
           ((Line)shape).setY2(50);
         }
         else if(shape instanceof Oval) {
           ((Oval)shape).setW(50);
           ((Oval)shape).setH(50);
         }
       }
     }
     //tell model to repaint applet or application.
     model.repaint();
   }
   
   /*
    * Overrides MouseAdapter's mouqseDragged method.
    */
   public void mouseDragged(MouseEvent e) {
     //get the current shape handled by the model.
     shape = model.getCurrentShape();
     //if there's a current shape in the model.
     if(shape != null){
       //if we are in DRAW mode.
       if (model.getAction() == Model.DRAW) {

       //if the shape is an instance of Rectangle or a descendant of Rectangle
       if(shape instanceof Rectangle) {
         //set the x and y location of the shape (allows rubber banding).
         //set its width and height.
         shape.setX(Math.min(startX, e.getX()));
         shape.setY(Math.min(startY, e.getY()));
         ((Rectangle) shape).setW(Math.abs(startX - e.getX()));
         ((Rectangle) shape).setH(Math.abs(startY = e.getY()));
       }
       else if(shape instanceof Oval) {
         //set the x and y location of the shape (allows rubber banding).
         //set its width and height.
         shape.setX(Math.min(startX, e.getX()));
         shape.setY(Math.min(startY, e.getY()));
         ((Oval) shape).setW(Math.abs(startX - e.getX()));
         ((Oval) shape).setH(Math.abs(startY = e.getY()));
       }
       else if (shape instanceof Line) {
         ((Line)shape).setX2(e.getX());
         ((Line)shape).setY2(e.getY());
       }
     }
   } 
     //tell model to repaint the applet or application.
     model.repaint();
   } 
}
