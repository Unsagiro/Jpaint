package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import model.selectedList;
import model.shapeState;
import model.shapesList;
import model.shapesListGetter;
import model.whatShapeStrategyChoose;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class MoveCommand implements ICommand, IUndoable {

	public PaintCanvasBase paintCanvas;
	public PointJpaint startPoint;
	public PointJpaint endPoint;
	Graphics2D graphics2d;
	public   ArrayList<ShapeDrawCommand> oldSelectedShapesLocal = new  ArrayList<ShapeDrawCommand>();
	public   ArrayList<ShapeDrawCommand> newSelectedShapesLocal = new  ArrayList<ShapeDrawCommand>();
	public double x;
	public double y;
	
	public MoveCommand( PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint)
			{
				this.paintCanvas = paintCanvas;
				this.startPoint = startPoint;
				this.endPoint = endPoint;
			}

	
	
	public void run() throws IOException {

		
		x = (endPoint.getX() - startPoint.getX());
		y =  (endPoint.getY() - startPoint.getY());
		
		
		selectedList.selected.removeAll(oldSelectedShapesLocal);
		
		 for (ShapeDrawCommand shape : selectedList.selected) // for shape selected
			{
			
				oldSelectedShapesLocal.add(shape);
			
				PointJpaint newStartPoint = new PointJpaint(shape.startPoint.getX() + x, shape.startPoint.getY() + y ); 
				PointJpaint newEndPoint = new PointJpaint(shape.endPoint.getX() + x, shape.endPoint.getY() + y );
				ShapeDrawCommand newShapeCommand = new ShapeDrawCommand(shape.paintCanvas, newStartPoint, newEndPoint, shape.width, shape.height, shape.shape);	
 			
				newSelectedShapesLocal.add(newShapeCommand);
			}
				 			
				
		
		
		graphics2d = paintCanvas.getGraphics2D();                            // clear the canvas
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0,0, 1920, 1080);
		
		
				 			
		shapesListGetter.getShapesList().removeAllShapes(oldSelectedShapesLocal);
		shapesListGetter.getShapesList().addAllShapes(newSelectedShapesLocal);
				 				
				 			
		selectedList.selected.removeAll(oldSelectedShapesLocal);
		selectedList.selected.addAll(newSelectedShapesLocal);

    		
		CommandHistory.add(this);
		
	}



	@Override
	public void undo() {
		// TODO Auto-generated method stub
	
		
		 for (ShapeDrawCommand newSelShape : newSelectedShapesLocal) // for shape selected
				{
					shapesListGetter.getShapesList().removeShape(newSelShape);
				
				}
			
			
		graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0,0, 1920, 1080);   // clear canvas
		
		
		
		 for (ShapeDrawCommand oldSelShape :  oldSelectedShapesLocal)
				{
					shapesListGetter.getShapesList().addShape(oldSelShape);
				}
		
		
		
     // System.out.println("newSelected has " + oldSelected.size() + " shapes inside");
    
		}

	@Override
	public void redo() {///////////////main bug is here
		

			for (ShapeDrawCommand oldSelShape : oldSelectedShapesLocal) // for shape selected
					{
						shapesListGetter.getShapesList().removeShape(oldSelShape);
				
					}
			
		graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0,0, 1920, 1080);
		
			
			for (ShapeDrawCommand newSelShape :  newSelectedShapesLocal)
					{
						shapesListGetter.getShapesList().addShape(newSelShape);
					}
		
			
   		
   		}


	}


		
