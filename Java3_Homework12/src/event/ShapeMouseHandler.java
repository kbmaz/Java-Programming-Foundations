package event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;
import shapes.Rectangle;
import shapes.Triangle;
import shapes.Line;
import shapes.Shape;

public class ShapeMouseHandler extends MouseAdapter {
  private Model model;
  
  //Start x and y location used to mark where the upper left corner of a shape is.
  private int startX;
  private int startY;
  
  //Distance from mouse click position in shape initial point.
  private int deltaX, deltaX2;
  private int deltaY, deltaY2;
  
  //private Color darkShade = model.getLineColor().darker();
  
  private Shape shape;
  
  public ShapeMouseHandler(Model model) {
     //persist local variable model to this.model.
     this.model = model;
   }
   
  /*
   * OVerrides MouseAdapter mousePressed method.
   */
  public void mousePressed(MouseEvent e) {
     
     if (model.getAction() == Model.Action.DRAW) {
       
       //have the model create a new shape for us.
       shape = model.createShape();
       
       //set its upper left x and y to where the mouse was pressed.
       shape.setX(e.getX());
       shape.setY(e.getY());
       
       //Set a default width and height or ending location in case user does not drag mouse.
       //Currently only instances of Rectangle or its descendants are used.
       if (shape instanceof Rectangle) {
         ((Rectangle)shape).setWidth(50);
         ((Rectangle)shape).setHeight(50);
       }
       else if(shape instanceof Triangle) {
         ((Triangle)shape).setWidth(50);
         ((Triangle)shape).setHeight(50);
       }
       else if (shape instanceof Line) {
         ((Line)shape).setX2(50);
         ((Line)shape).setY2(50);
       }
     }   
     
     else {
     shape = model.returnSelectShape(e.getX(), e.getY());
     
       if(shape != null) {
       
         //Get distance from mouse click position to shape initial point
         if(model.getAction() == Model.Action.MOVE) {
           deltaX = e.getX() - shape.getX();
           deltaY = e.getY() - shape.getY();

         //Get distance from mouse click position to end point  
         if(shape instanceof Line) {
           deltaX2 = e.getX() - ((Line)shape).getX2();
           deltaY2 = e.getY() - ((Line)shape).getY2();
         }
         }
         //On mouse click remove shape from ArrayList
         else if(model.getAction() == Model.Action.REMOVE) {
           model.getShapeArrayList().remove(shape);
         }
         
         else if(model.getAction() == Model.Action.CHANGE) { 
           shape.setLineColor(model.getLineColor());

           if (shape instanceof Rectangle) {
            ((Rectangle) shape).setFillColor(model.getFillColor());
           }
           if (shape instanceof Triangle) {
             ((Triangle) shape).setFillColor(model.getFillColor());
            }
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
       
    model.getCurrentShape();
    
      //if there's a current shape in the model.
      if(shape != null){
        
        //if we are in DRAW mode.
        if (model.getAction() == Model.Action.DRAW || model.getAction() == Model.Action.RESIZE) { 
          
              //if the shape is an instance of Rectangle or a descendant
               if(shape instanceof Rectangle) {
                 //set the x and y location of the shape (allows rubber banding).
                 //set its width and height.
                 shape.setX(Math.min(startX, e.getX()));
                 shape.setY(Math.min(startY, e.getY()));
                 ((Rectangle) shape).setWidth(Math.abs(startX - e.getX()));
                 ((Rectangle) shape).setHeight(Math.abs(startY - e.getY()));
                 } 
             //if the shape is an instance of Triangle or a descendant
               else if(shape instanceof Triangle) {
                 //set the x and y location of the shape (allows rubber banding).
                 //set its width and height.
                 shape.setX(Math.min(startX, e.getX()));
                 shape.setY(Math.min(startY, e.getY()));
                 ((Triangle) shape).setWidth(Math.abs(startX - e.getX()));
                 ((Triangle) shape).setHeight(Math.abs(startY - e.getY()));
                 }
               else if (shape instanceof Line) {
                 ((Line)shape).setX2(e.getX());
                 ((Line)shape).setY2(e.getY());
               }
       }
       //Set point of shape based on current mouse position 
       //& distances from mouse point to all shape points
       else if(model.getAction() == Model.Action.MOVE) {

               if(shape instanceof Rectangle || shape instanceof Triangle) {
                 shape.setX(e.getX() - deltaX);
                 shape.setY(e.getY() - deltaY);
               }
               //Move end point and start position
               if(shape instanceof Line) {
                 ((Line)shape).setX2(e.getX() - deltaX2);
                 ((Line)shape).setY2(e.getY() - deltaY2);
               }
       }
     }  
     //tell model to repaint the applet or application.
     model.repaint();
   }
}



